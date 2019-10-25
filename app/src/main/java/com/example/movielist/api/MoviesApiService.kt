package com.example.movielist.api

import com.example.movielist.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    @GET("/3/discover/movie?api_key=2c717caffe21eb06d0ab37a105a01f48&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getMovies(@Query("primary_release_year") year: String): Call<Result>
}