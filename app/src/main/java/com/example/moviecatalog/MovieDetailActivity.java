package com.example.moviecatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.moviecatalog.databinding.ActivityMainBinding;
import com.example.moviecatalog.databinding.ActivityMovieDetailBinding;

public class MovieDetailActivity extends AppCompatActivity {

    private ActivityMovieDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Movie movie = getIntent().getParcelableExtra("EXTRA");
        setupToolbar(movie);
        setData(movie);
    }
    private void setupToolbar(Movie movie) {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
        binding.toolbar.setTitle(movie.getTittle());
    }
    private void setData(Movie movie) {
        Glide.with(this).load(movie.getPoster()).into(binding.ivPoster);
        binding.tvDirector.setText(getString(R.string.movie_director,movie.getDirector()));
        binding.tvGenere.setText(getString(R.string.movie_genere,movie.getGenere()));
        binding.tvYear.setText(getString(R.string.movie_year, movie.getYear()));
        binding.tvSummary.setText(movie.getSummary());
    }

}