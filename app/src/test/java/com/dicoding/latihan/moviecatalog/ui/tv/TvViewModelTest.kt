package com.dicoding.latihan.moviecatalog.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
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
class TvViewModelTest {
    private lateinit var viewModel: TvViewModel
    private val sort = SortUtils.DEFAULT

    @get:Rule
    var instanceTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTvRepository: MovieTvRepository

    @Mock
    private lateinit var observer : Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pageList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvViewModel(movieTvRepository)
    }

    @Test
    fun testGetTvShow() {
        val dummyTvShow = Resource.succes(pageList)
        `when`(dummyTvShow.data?.size).thenReturn(10)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShow

        `when`(movieTvRepository.getAllTvShow(sort)).thenReturn(tvShows)
        val tvEntities = viewModel.getTvShow(sort).value?.data
        verify(movieTvRepository).getAllTvShow(sort)
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities?.size)

        viewModel.getTvShow(sort).observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}