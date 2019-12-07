package com.buckun.recyclerviewtutorial.apiInterface;


import com.buckun.recyclerviewtutorial.model.Movie;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("movies")
    Call<ArrayList<Movie>> getAllMovies();
}
