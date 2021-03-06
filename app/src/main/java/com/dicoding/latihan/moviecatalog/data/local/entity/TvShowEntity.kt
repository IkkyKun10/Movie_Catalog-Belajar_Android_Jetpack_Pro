package com.dicoding.latihan.moviecatalog.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvShowId")
        var tvShowId: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "image")
        var image: String,

        @ColumnInfo(name = "date")
        var date: String,

        @ColumnInfo(name = "genre")
        var genre: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "kreator")
        var kreator: String,

        @ColumnInfo(name = "score")
        var score: String,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
)