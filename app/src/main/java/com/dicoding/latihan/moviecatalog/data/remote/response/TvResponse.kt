package com.dicoding.latihan.moviecatalog.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvResponse(
        var tvShowId : String,
        var title : String,
        var image : String,
        var date : String,
        var genre : String,
        var description : String,
        var kreator : String,
        var score : String
): Parcelable
