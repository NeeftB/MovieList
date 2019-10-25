package com.example.movielist.model

import com.google.gson.annotations.SerializedName
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("original_title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var rating: Float,
    @SerializedName("overview") var overview: String,
    @SerializedName("backdrop_path") var backdropImage: String,
    @SerializedName("poster_path") var posterImage: String

) : Parcelable {
    fun getPosterImageUrl() =
        "https://image.tmdb.org/t/p/original/$posterImage"

    fun getBackdropImageUrl() =
        "https://image.tmdb.org/t/p/original/$backdropImage"
}