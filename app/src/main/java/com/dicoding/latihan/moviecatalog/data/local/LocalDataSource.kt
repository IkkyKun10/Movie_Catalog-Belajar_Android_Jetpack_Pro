package com.dicoding.latihan.moviecatalog.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.local.room.MovieTvDao
import com.dicoding.latihan.moviecatalog.utils.SortUtils

class LocalDataSource private constructor(private val mMovieTvDao: MovieTvDao) {

    companion object {
        private var INSTANCE : LocalDataSource? = null

        fun getInstance(movieTvDao: MovieTvDao) : LocalDataSource {
            if (INSTANCE == null) {
                INSTANCE = LocalDataSource(movieTvDao)
            }
            return INSTANCE as LocalDataSource
        }
    }

    fun getAllMovies(sort: String) : DataSource.Factory<Int, MoviesEntity> {
        val query = SortUtils.getSortedQueryMovie(sort)
        return mMovieTvDao.getAllMovies(query)
    }

    fun getAllTvShow(sort: String) :  DataSource.Factory<Int, TvShowEntity> {
        val query = SortUtils.getSortedQueryTvShow(sort)
        return mMovieTvDao.getAllTvShow(query)
    }

    fun getListFavoriteMovie() : DataSource.Factory<Int, MoviesEntity> = mMovieTvDao.getListFavoriteMovie()

    fun getListFavoriteTvShow() : DataSource.Factory<Int, TvShowEntity> = mMovieTvDao.getListFavoriteTvShow()

    fun getDetailMovie(moviesId: String) :LiveData<MoviesEntity> = mMovieTvDao.getDetailMovies(moviesId)

    fun getDetailTvShow(tvShowId: String) : LiveData<TvShowEntity> = mMovieTvDao.getDetailTvShow(tvShowId)

    fun insertMovies(movies: List<MoviesEntity>) = mMovieTvDao.insertMovies(movies)

    fun insertTvShow(tvShow: List<TvShowEntity>) = mMovieTvDao.insertTvShow(tvShow)

    fun setMoviesFavorite(movies: MoviesEntity, newState: Boolean) {
        movies.favorite = newState
        mMovieTvDao.updateMovies(movies)
    }

    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.favorite = newState
        mMovieTvDao.updateTvShow(tvShow)
    }
}