package com.example.movielist.ui.movieInfo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.model.Movie

import kotlinx.android.synthetic.main.activity_movie_info.*
import kotlinx.android.synthetic.main.content_movie_info.*


class MovieInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        val movie = intent.getParcelableExtra<Movie>(MOVIE_INFO)

        if(movie != null) {
            tvMovieTitle.text = movie.title
            tvReleaseDate.text = movie.releaseDate
            tvVote.text = movie.rating.toString()
            tvOverviewText.text = movie.overview
            Glide.with(this).load(movie.getPosterImageUrl()).into(ivPosterImage)
            Glide.with(this).load(movie.getBackdropImageUrl()).into(ivBackdropImage)
        }

    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    companion object {
        const val MOVIE_INFO = "Movie Info"
    }
}
