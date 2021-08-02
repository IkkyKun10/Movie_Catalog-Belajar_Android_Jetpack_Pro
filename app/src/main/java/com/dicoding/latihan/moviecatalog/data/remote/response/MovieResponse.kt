package com.dicoding.latihan.moviecatalog.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
        var moviesId : String,
        var title : String,
        var image : String,
        var date : String,
        var genre : String,
        var description : String,
        var director : String,
        var score : String
) : Parcelable