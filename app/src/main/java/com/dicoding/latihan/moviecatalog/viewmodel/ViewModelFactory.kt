package com.dicoding.latihan.moviecatalog.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.latihan.moviecatalog.data.source.MovieTvRepository
import com.dicoding.latihan.moviecatalog.di.Injection
import com.dicoding.latihan.moviecatalog.ui.detail.DetailFilmViewModel
import com.dicoding.latihan.moviecatalog.ui.movie.MovieViewModel
import com.dicoding.latihan.moviecatalog.ui.taskbar.FavoriteViewModel
import com.dicoding.latihan.moviecatalog.ui.tv.TvViewModel

class ViewModelFactory private constructor(private val mMovieTvRepository: MovieTvRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository(context))
                }

    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(TvViewModel::class.java) -> {
                return TvViewModel(mMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(DetailFilmViewModel::class.java) -> {
                return DetailFilmViewModel(mMovieTvRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                return FavoriteViewModel(mMovieTvRepository) as T
            }
            else ->throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

}