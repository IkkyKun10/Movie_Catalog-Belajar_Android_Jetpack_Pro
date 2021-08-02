package com.dicoding.latihan.moviecatalog.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import com.dicoding.latihan.moviecatalog.vo.Resource

class MovieViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {

    fun getMovies(sort: String) : LiveData<Resource<PagedList<MoviesEntity>>> = movieTvRepository.getAllMovies(sort)
}