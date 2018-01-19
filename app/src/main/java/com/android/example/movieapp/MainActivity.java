package com.android.example.movieapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String POPULAR_MOVIE_API = "http://api.themoviedb.org/3/movie/popular?api_key=3c15dbf274c6641b91228b202383fdc9";
    private static final String TOP_RATED_MOVIE_API = "https://api.themoviedb.org/3/movie/top_rated?api_key=3c15dbf274c6641b91228b202383fdc9";
    private MovieAppAdapter mAdapter;

    private static final String TITLE = "title";
    private static final String DECRIPTION = "decription";
    private static final String RELEASEDATE = "release_date";
    private static final String POSTERURL = "poster_url";
    private static final String VOTEAVERAGE = "vote_average";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.grid_view);

        mAdapter = new MovieAppAdapter(this, new ArrayList<MovieApp>());
        gridView.setAdapter(mAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(), MovieDetails.class);

                String title = mAdapter.getItem(i).getTitle();
                String releaseDate = mAdapter.getItem(i).getReleaseData();
                String decription = mAdapter.getItem(i).getDescrption();
                double voteAverage = mAdapter.getItem(i).getVoteAverage();
                String posterUrl = mAdapter.getItem(i).getPosterUrl();

                intent.putExtra(TITLE, title);
                intent.putExtra(RELEASEDATE, releaseDate);
                intent.putExtra(DECRIPTION, decription);
                intent.putExtra(VOTEAVERAGE, voteAverage);
                intent.putExtra(POSTERURL, posterUrl);


                startActivity(intent);
            }
        });

        MovieAppAsyncTask task = new MovieAppAsyncTask();
        task.execute(POPULAR_MOVIE_API);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.top_rated) {
            new MovieAppAsyncTask().execute(TOP_RATED_MOVIE_API);
            return true;
        }
        if (id == R.id.popular) {
            new MovieAppAsyncTask().execute(POPULAR_MOVIE_API);
        }
        return super.onOptionsItemSelected(item);
    }

    private class MovieAppAsyncTask extends AsyncTask<String, Void, List<MovieApp>> {
        @Override
        protected List<MovieApp> doInBackground(String... strings) {
            if (strings.length < 1 || strings[0] == null) {
                return null;
            }
            List<MovieApp> result = MovieQurey.fetchMovieAppData(strings[0]);
            return result;
        }

        @Override
        protected void onPostExecute(List<MovieApp> movieApps) {
            mAdapter.clear();
            if (movieApps != null && !movieApps.isEmpty()) {
                mAdapter.addAll(movieApps);
            }
        }
    }
}
