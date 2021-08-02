package com.dicoding.latihan.moviecatalog.ui.taskbar

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository

class FavoriteViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {

    fun getListMovieFavorite() : LiveData<PagedList<MoviesEntity>> =
            movieTvRepository.getListFavoriteMovies()

    fun getListTvShowFavorite() : LiveData<PagedList<TvShowEntity>> =
            movieTvRepository.getListFavoriteTvShow()

    fun setMovieFavorite(movies: MoviesEntity) {
        val newState = !movies.favorite
        movieTvRepository.setFavoriteMovie(movies, newState)
    }

    fun setTvShowFavorite(tvShow: TvShowEntity) {
        val newState = !tvShow.favorite
        movieTvRepository.setFavoriteTvShow(tvShow, newState)
    }
}