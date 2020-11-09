package com.example.moviecatalog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

        @GET("simple-api/static_list_example.json")
        Call<List<Movie>> getMovies();
    }


