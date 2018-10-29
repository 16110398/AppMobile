package com.listyawan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {
    private ImageView image;

    private TextView title, date, rating, overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        image = (ImageView) findViewById(R.id.img_besar);

        title = (TextView) findViewById(R.id.txt_title);

        rating = (TextView) findViewById(R.id.txt_vote);

        date = (TextView) findViewById(R.id.txt_release);

        overview = (TextView) findViewById(R.id.txt_sinopsis);

        MovieDetails details = (MovieDetails) getIntent().getExtras().getSerializable("MOVIE_DETAILS");

        if (details !=null){
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+details.getPoster_path()).into(image);
            title.setText(details.getOriginal_title());
            date.setText(details.getRelease_date());
            rating.setText(Double.toString(Double.parseDouble(details.getVote_average())));
            overview.setText(details.getOverview());

        }
    }
}
