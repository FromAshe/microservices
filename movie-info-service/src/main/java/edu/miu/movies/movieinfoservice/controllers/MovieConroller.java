package edu.miu.movies.movieinfoservice.controllers;

import edu.miu.movies.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieConroller {
    @RequestMapping({"/{movieId}"})
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
    return new Movie(movieId, "Test name");
    }
}
