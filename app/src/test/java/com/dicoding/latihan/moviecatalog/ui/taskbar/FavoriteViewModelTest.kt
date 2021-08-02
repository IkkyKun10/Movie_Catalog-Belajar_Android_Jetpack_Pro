package com.dicoding.latihan.moviecatalog.ui.taskbar

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instanceTaskRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MoviesEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePageList: PagedList<MoviesEntity>

    @Mock
    private lateinit var tvshowPageList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieTvRepository)
    }

    @Test
    fun testGetListMovieFavorite() {
        val dummyMovies = moviePageList
        `when`(dummyMovies.size).thenReturn(10)
        val movies = MutableLiveData<PagedList<MoviesEntity>>()
        movies.value = dummyMovies

        `when`(movieTvRepository.getListFavoriteMovies()).thenReturn(movies)
        val movieEntities = viewModel.getListMovieFavorite().value
        verify(movieTvRepository).getListFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getListMovieFavorite().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    @Test
    fun testGetListTvShowFavorite() {
        val dummyTvShow = tvshowPageList
        `when`(dummyTvShow.size).thenReturn(10)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        `when`(movieTvRepository.getListFavoriteTvShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getListTvShowFavorite().value
        verify(movieTvRepository).getListFavoriteTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getListTvShowFavorite().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

}