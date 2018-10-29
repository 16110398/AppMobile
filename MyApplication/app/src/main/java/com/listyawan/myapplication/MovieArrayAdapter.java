package com.listyawan.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Listyawan on 29/10/2018.
 */

public class MovieArrayAdapter extends ArrayAdapter {

    private List<MovieDetails> movieDetailsList;
    private int resource;
    private Context context;

    public MovieArrayAdapter(Context context, int resource, List<MovieDetails> movieDetails) {
        super(context, resource, movieDetails);
        this.context = context;
        this.movieDetailsList = movieDetails;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieDetails details = movieDetailsList.get(position);

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        TextView movieName = (TextView) view.findViewById(R.id.txt_judul);
        TextView movieOver = (TextView) view.findViewById(R.id.txt_deskripsi);
        TextView movieRate = (TextView) view.findViewById(R.id.txt_rating);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);


        movieName.setText(details.getOriginal_title());
        movieOver.setText(details.getOverview());
        movieRate.setText(details.getVote_average());

        Glide.with(context).load("https://image.tmdb.org/t/p/w500/"+details.getPoster_path()).into(image);

        return view;
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return movieDetailsList.get(position);
    }
}
