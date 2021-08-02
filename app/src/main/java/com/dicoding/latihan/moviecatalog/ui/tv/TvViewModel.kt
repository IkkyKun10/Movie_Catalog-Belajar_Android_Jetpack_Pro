package com.dicoding.latihan.moviecatalog.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import com.dicoding.latihan.moviecatalog.vo.Resource

class TvViewModel(private val movieTvRepository: MovieTvRepository) : ViewModel() {

    fun getTvShow(sort: String) : LiveData<Resource<PagedList<TvShowEntity>>> = movieTvRepository.getAllTvShow(sort)
}