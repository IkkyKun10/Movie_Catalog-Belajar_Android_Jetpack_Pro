package com.dicoding.latihan.moviecatalog.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.latihan.moviecatalog.data.local.LocalDataSource
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.remote.RemoteDataSource
import com.dicoding.latihan.moviecatalog.utils.*
import com.dicoding.latihan.moviecatalog.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.mockito.Mockito.*
import com.nhaarman.mockitokotlin2.verify
import org.junit.Rule
import org.junit.Test


class MovieTvRepositoryTest {

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieTvRepository = FakeMovieTvRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateRemoteDummyMovies()
    private val moviesId = movieResponse[0].moviesId
    private val tvShowResponse = DataDummy.generateRemoteDummyTvShow()
    private val tvShowId = tvShowResponse[0].tvShowId

    private val sort = SortUtils.DEFAULT

    @Test
    fun testGetAllMovies() {
       val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getAllMovies(sort)).thenReturn(dataSourceFactory)
        movieTvRepository.getAllMovies(sort)

        val movieEntities = Resource.succes(PageListUtil.mockPageList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies(sort)
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun testGetAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow(sort)).thenReturn(dataSourceFactory)
        movieTvRepository.getAllTvShow(sort)

        val tvShowEntities = Resource.succes(PageListUtil.mockPageList(DataDummy.generateDummyTvshow()))
        verify(local).getAllTvShow(sort)
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun testGetDetailMovie() {
        val movie = DataDummy.generateDummyDetailMovie(DataDummy.generateDummyMovies()[0], false)
        val dummyMovie = MutableLiveData<MoviesEntity>()
        dummyMovie.value = movie
        `when`(local.getDetailMovie(moviesId)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtils.getValue(movieTvRepository.getDetailMovie(moviesId))
        verify(local).getDetailMovie(moviesId)
        assertNotNull(movieEntities)
        assertNotNull(movieEntities.title)
        assertEquals(movieResponse[0].title, movieEntities.title)
    }

    @Test
    fun testGetDetailTvShow() {
        val tvShow = DataDummy.generateDummyDetailTv(DataDummy.generateDummyTvshow()[0], false)
        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = tvShow
        `when`(local.getDetailTvShow(tvShowId)).thenReturn(dummyTvShow)

        val tvShowEntities = LiveDataTestUtils.getValue(movieTvRepository.getDetailTvShow(tvShowId))
        verify(local).getDetailTvShow(tvShowId)
        assertNotNull(tvShowEntities)
        assertNotNull(tvShowEntities.title)
        assertEquals(tvShowResponse[0].title, tvShowEntities.title)
    }

    @Test
    fun testGetListFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MoviesEntity>
        `when`(local.getListFavoriteMovie()).thenReturn(dataSourceFactory)
        movieTvRepository.getListFavoriteMovies()

        val movieEntities = Resource.succes(PageListUtil.mockPageList(DataDummy.generateDummyMovies()))
        verify(local).getListFavoriteMovie()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun testGetListFavoriteTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getListFavoriteTvShow()).thenReturn(dataSourceFactory)
        movieTvRepository.getListFavoriteTvShow()

        val tvShowEntities = Resource.succes(PageListUtil.mockPageList(DataDummy.generateDummyTvshow()))
        verify(local).getListFavoriteTvShow()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}