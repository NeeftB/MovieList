package com.example.movielist.repository

import com.example.movielist.api.MoviesApi
import com.example.movielist.api.MoviesApiService

class MoviesRepository {
    private val moviesApi: MoviesApiService = MoviesApi.createApi()

    fun getMovies(year: String) = moviesApi.getMovies(year)
}