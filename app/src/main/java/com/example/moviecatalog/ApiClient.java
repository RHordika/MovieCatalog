package com.example.moviecatalog;

import android.content.Context;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    Retrofit retrofit;
    Context context;

    public ApiClient(Context context) {
        this.context = context;

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://marioguillermo.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public Call<List<Movie>> getMovies() {
        Api service = retrofit.create(Api.class);
        return service.getMovies();
    }
}
