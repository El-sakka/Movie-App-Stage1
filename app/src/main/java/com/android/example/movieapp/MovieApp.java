package com.android.example.movieapp;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mahmoud on 05/10/17.
 */

public class MovieApp {
    private String title;
    private String releaseData;
    private String descrption;
    private double voteAverage;
    private String posterUrl;
    private ArrayList<String> trailers;

    public MovieApp(String title, String posterUrl, String releaseData, double voteAverage, String descrption) {
        this.title = title;
        this.posterUrl = posterUrl;
        this.releaseData = releaseData;
        this.voteAverage = voteAverage;
        this.descrption = descrption;
    }

    public MovieApp(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public String getReleaseData() {
        return this.releaseData;
    }

    public String getPosterUrl() {
        return this.posterUrl;
    }

    public String getDescrption() {
        return this.descrption;
    }

    public double getVoteAverage() {
        return this.voteAverage;
    }
    public void setTailer(String trailer){
        trailers.add(trailer);
    }
}
