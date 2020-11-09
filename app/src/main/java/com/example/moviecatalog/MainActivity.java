package com.example.moviecatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.moviecatalog.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MoviesAdapter.MovieClickListener {

    ActivityMainBinding binding;
    MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new MoviesAdapter(this);
        adapter.setMovieClickListener(this);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerView.setAdapter(adapter);
        binding.sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        ApiClient apiClient = new ApiClient(this);
        apiClient.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()){
                    binding.progressBar.setVisibility(View.GONE);
                    adapter.setItems(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Problema con el server",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onMovieClicked(Movie movie) {
        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("EXTRA", movie);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "year: " + movie.getYear(), Toast.LENGTH_LONG).show();
    }

}
