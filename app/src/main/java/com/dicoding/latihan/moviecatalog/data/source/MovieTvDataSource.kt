package com.dicoding.latihan.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.vo.Resource

interface MovieTvDataSource {
    fun getAllMovies(sort: String) : LiveData<Resource<PagedList<MoviesEntity>>>

    fun getAllTvShow(sort: String) : LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailMovie(moviesId: String) : LiveData<MoviesEntity>

    fun getDetailTvShow(tvShowId: String) : LiveData<TvShowEntity>

    fun getListFavoriteMovies() : LiveData<PagedList<MoviesEntity>>

    fun getListFavoriteTvShow() : LiveData<PagedList<TvShowEntity>>

    fun setFavoriteMovie(movie: MoviesEntity, newState: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean)
}