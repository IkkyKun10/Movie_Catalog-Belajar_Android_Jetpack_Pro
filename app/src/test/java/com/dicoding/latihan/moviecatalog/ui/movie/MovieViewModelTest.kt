package com.dicoding.latihan.moviecatalog.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import com.dicoding.latihan.moviecatalog.utils.SortUtils
import com.dicoding.latihan.moviecatalog.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel
    private val sort = SortUtils.DEFAULT

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var observer : Observer<Resource<PagedList<MoviesEntity>>>

    @Mock
    private lateinit var pageList: PagedList<MoviesEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieTvRepository)
    }

    @Test
    fun testGetMovies() {
        val dummyMovies = Resource.succes(pageList)
        `when`(dummyMovies.data?.size).thenReturn(10)
        val movies = MutableLiveData<Resource<PagedList<MoviesEntity>>>()
        movies.value = dummyMovies

        `when`(movieTvRepository.getAllMovies(sort)).thenReturn(movies)
        val moviesEntities = viewModel.getMovies(sort).value?.data
        verify(movieTvRepository).getAllMovies(sort)
        assertNotNull(moviesEntities)
        assertEquals(10, moviesEntities?.size)

        viewModel.getMovies(sort).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}