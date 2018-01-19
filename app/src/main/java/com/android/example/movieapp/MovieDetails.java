package com.android.example.movieapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by mahmoud on 05/10/17.
 */

public class MovieDetails extends AppCompatActivity {

    private static final String TITLE = "title";
    private static final String DECRIPTION = "decription";
    private static final String RELEASEDATE = "release_date";
    private static final String POSTERURL = "poster_url";
    private static final String VOTEAVERAGE = "vote_average";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);
        Intent intent = getIntent();

        String title = intent.getStringExtra(TITLE);
        String decription = intent.getStringExtra(DECRIPTION);
        String releaseDate = intent.getStringExtra(RELEASEDATE);
        String posterUrl = intent.getStringExtra(POSTERURL);
        double voteAverage = intent.getDoubleExtra(VOTEAVERAGE, 0.0);

        TextView originalTitle = (TextView) findViewById(R.id.movie_title_textView);
        originalTitle.setText(title);

        ImageView posterImage = (ImageView) findViewById(R.id.movie_imgaeView);
        Picasso.with(getApplicationContext()).load(posterUrl).into(posterImage);

        TextView releaseDateTextView = (TextView) findViewById(R.id.release_date_textView);
        releaseDateTextView.setText(releaseDate);

        TextView voteAverageTextView = (TextView) findViewById(R.id.vote_average_textView);
        voteAverageTextView.setText(String.valueOf(voteAverage));

        TextView descriptionTextView = (TextView) findViewById(R.id.descrption_textView);
        descriptionTextView.setText(decription);

    }
}
