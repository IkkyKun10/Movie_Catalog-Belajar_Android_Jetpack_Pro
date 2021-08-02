package com.dicoding.latihan.moviecatalog.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import com.dicoding.latihan.moviecatalog.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailFilmViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvshow()[0]
    private val moviesId = dummyMovies.moviesId
    private val tvShowsId = dummyTvShow.tvShowId

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var moviesObserver: Observer<MoviesEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailFilmViewModel(movieTvRepository)
        viewModel.setSelectedMovie(moviesId)
        viewModel.setSelectedTv(tvShowsId)
    }

    @Test
    fun testGetMovies() {
        val dummyFavorite = DataDummy.generateDummyDetailMovie(dummyMovies, true)
        val getMovies = MutableLiveData<MoviesEntity>()
        getMovies.value = dummyFavorite

        `when`(movieTvRepository.getDetailMovie(moviesId)).thenReturn(getMovies)

        viewModel.movies.observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyFavorite)
    }


    @Test
    fun testGetTv() {
        val dummyFavorite = DataDummy.generateDummyDetailTv(dummyTvShow, true)
        val getTvShow = MutableLiveData<TvShowEntity>()
        getTvShow.value = dummyFavorite

        `when`(movieTvRepository.getDetailTvShow(tvShowsId)).thenReturn(getTvShow)

        viewModel.tvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyFavorite)
    }
}