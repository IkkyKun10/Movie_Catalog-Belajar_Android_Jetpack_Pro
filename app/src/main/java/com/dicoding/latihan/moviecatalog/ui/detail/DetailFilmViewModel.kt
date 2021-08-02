package com.dicoding.latihan.moviecatalog.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository

class DetailFilmViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {

    val moviesId = MutableLiveData<String>()
    val tvShowsId = MutableLiveData<String>()

    fun setSelectedMovie(moviesId : String) {
        this.moviesId.value = moviesId
    }

    fun setSelectedTv(tvShowsId : String) {
        this.tvShowsId.value = tvShowsId
    }

    var movies: LiveData<MoviesEntity> = Transformations.switchMap(moviesId) {mMoviesId ->
        movieTvRepository.getDetailMovie(mMoviesId)
    }

    var tvShow: LiveData<TvShowEntity> = Transformations.switchMap(tvShowsId) {mTvShowId ->
        movieTvRepository.getDetailTvShow(mTvShowId)
    }

    fun setFavoriteMovie() {
        val movieResource = movies.value
        if (movieResource != null) {
            val newState = !movieResource.favorite
            movieTvRepository.setFavoriteMovie(movieResource, newState)
        }
    }

    fun setFavoriteTv() {
        val tvShowResource = tvShow.value
        if (tvShowResource != null) {
            val newState = !tvShowResource.favorite
            movieTvRepository.setFavoriteTvShow(tvShowResource, newState)
        }
    }

}