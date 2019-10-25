package com.example.movielist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.R
import com.example.movielist.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private val movies: List<Movie>, private val onClick: (Movie) -> Unit)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvMovieNumber.text = context.getString(R.string.movie_number, (position + 1).toString())
        holder.bind(movies[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(movies[adapterPosition]) }
        }

        fun bind(movieItem: Movie) {
            Glide.with(context).load(movieItem.getPosterImageUrl()).into(itemView.ivMovie)
        }
    }


}