package edu.miu.movies.movieinfoservice.models;

public class Movie {

    private String miveId;
    private String name;

    public Movie(String miveId, String name) {
        this.miveId = miveId;
        this.name = name;
    }

    public String getMiveId() {
        return miveId;
    }

    public void setMiveId(String miveId) {
        this.miveId = miveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
