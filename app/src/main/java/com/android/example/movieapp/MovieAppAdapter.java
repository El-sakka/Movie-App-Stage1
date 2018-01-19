package com.android.example.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mahmoud on 05/10/17.
 */

public class MovieAppAdapter extends ArrayAdapter<MovieApp> {
    public MovieAppAdapter(Context context, ArrayList<MovieApp> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;
        if (convertView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.custom_layout, parent, false);
        }
        MovieApp movieApp = getItem(position);

        ImageView posterImageView = (ImageView) rootView.findViewById(R.id.poster_imageView);
        Picasso.with(getContext()).load(movieApp.getPosterUrl()).into(posterImageView);
        return rootView;
    }
}
