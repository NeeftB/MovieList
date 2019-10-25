package com.example.movielist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result (

    @SerializedName("results")
    @Expose
    var movies: List<Movie>

)