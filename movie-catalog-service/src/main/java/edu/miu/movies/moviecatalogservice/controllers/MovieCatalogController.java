package edu.miu.movies.moviecatalogservice.controllers;

import edu.miu.movies.moviecatalogservice.models.CatalogItem;
import edu.miu.movies.moviecatalogservice.models.Movie;
import edu.miu.movies.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    //copy pasting a response and request object it technically ok, as opposed to the monolotic architecture.
    //get all rated movie IDs
    //for each movies Id, call movie info service and get detail
    @Autowired
    RestTemplate restTemplate;// it is going to be deprecated soon, it is synchronous
    List<Rating> ratings = Arrays.asList(
            new Rating("1234", 4),
            new Rating("5678", 3));
    //put them all together


    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        //Option 2 is to work with Webclient which is verbose as compared to the rest template
        WebClient.Builder builder = WebClient.builder();

        //The other problem is we are creating RestTemplate inside the getCatalog method and whenever
        //an api call to this method comes in new instantiate  anew restemplate which is expensive.
        //so we need to creat it once and share it across multiple class
        //RestTemplate restTemplate = new RestTemplate();
        return ratings.stream().map(rating ->{
            //when we use restTemplate we are hard codding the url and it is bad because we might change a port
            //and we want it to be dynamic
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "desc", rating.getRating());}).collect(Collectors.toList());
        //return  Collections.singletonList(new CatalogItem("Transformer", "Test", 4));

    }
}
