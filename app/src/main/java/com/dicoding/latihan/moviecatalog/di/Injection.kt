package com.dicoding.latihan.moviecatalog.di

import android.content.Context
import com.dicoding.latihan.moviecatalog.data.local.LocalDataSource
import com.dicoding.latihan.moviecatalog.data.local.room.MovieTvDatabase
import com.dicoding.latihan.moviecatalog.data.remote.RemoteDataSource
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import com.dicoding.latihan.moviecatalog.utils.AppExecutors
import com.dicoding.latihan.moviecatalog.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context) : MovieTvRepository {
        val database = MovieTvDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieTvDao())
        val appExecutors = AppExecutors()

        return MovieTvRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}