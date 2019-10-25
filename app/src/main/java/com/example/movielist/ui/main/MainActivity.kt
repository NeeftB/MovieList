package com.example.movielist.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.movielist.R
import com.example.movielist.adapter.MovieAdapter
import com.example.movielist.model.Movie
import com.example.movielist.ui.movieInfo.MovieInfoActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val movies = arrayListOf<Movie>()
    private val movieAdapter = MovieAdapter(movies) {
        movie -> onMovieClick(movie)
    }
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.movies.observe(this, Observer {
            movies.clear()
            movies.addAll(it)
            movieAdapter.notifyDataSetChanged()
        })
    }

    private fun initViews() {
        rvMovies.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        rvMovies.adapter = movieAdapter

        btnSubmit.setOnClickListener { onSubmitClick() }
    }

    private fun onSubmitClick() {
        viewModel.getMovie(etYear.text.toString())
    }

    private fun onMovieClick(movie: Movie) {
        val intent = Intent(this, MovieInfoActivity::class.java)
        intent.putExtra(MovieInfoActivity.MOVIE_INFO, movie)
        startActivity(intent)
    }
}
