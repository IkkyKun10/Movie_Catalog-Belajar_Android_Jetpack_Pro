package com.dicoding.latihan.moviecatalog.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "moviesentities")
data class MoviesEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "moviesId")
        var moviesId: String,

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

        @ColumnInfo(name = "director")
        var director: String,

        @ColumnInfo(name = "score")
        var score: String,

        @ColumnInfo(name = "favorite")
        var favorite: Boolean = false
    )