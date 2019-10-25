package com.example.movielist.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.movielist.model.Movie
import com.example.movielist.model.Result
import com.example.movielist.repository.MoviesRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val moviesRepository = MoviesRepository()
    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getMovie(year: String){
        moviesRepository.getMovies(year).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if(response.isSuccessful) movies.value = response.body()!!.movies
                else error.value = "An error occurred ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                error.value = t.message
            }
        })
    }

}