package com.dicoding.latihan.moviecatalog.data.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.latihan.moviecatalog.data.remote.response.MovieResponse
import com.dicoding.latihan.moviecatalog.data.remote.response.TvResponse
import com.dicoding.latihan.moviecatalog.utils.EspressoIdlingResource
import com.dicoding.latihan.moviecatalog.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS : Long = 1000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper) :RemoteDataSource =
                instance ?: synchronized(this) {
                    instance ?: RemoteDataSource(helper)
                }
    }

    fun getMovies() : LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovie())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getTvShow() : LiveData<ApiResponse<List<TvResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvResponse>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }
}