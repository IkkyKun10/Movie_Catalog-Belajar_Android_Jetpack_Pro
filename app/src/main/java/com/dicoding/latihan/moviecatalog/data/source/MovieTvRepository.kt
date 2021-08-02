package com.dicoding.latihan.moviecatalog.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.latihan.moviecatalog.data.local.LocalDataSource
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.remote.ApiResponse
import com.dicoding.latihan.moviecatalog.data.remote.RemoteDataSource
import com.dicoding.latihan.moviecatalog.data.remote.response.MovieResponse
import com.dicoding.latihan.moviecatalog.data.remote.response.TvResponse
import com.dicoding.latihan.moviecatalog.utils.AppExecutors
import com.dicoding.latihan.moviecatalog.vo.Resource

class MovieTvRepository private constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
) : MovieTvDataSource{

    companion object{
        @Volatile
        private var instance: MovieTvRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): MovieTvRepository =
            instance ?: synchronized(this) {
                instance ?: MovieTvRepository(remoteData, localDataSource, appExecutors)
            }
    }


    override fun getAllMovies(sort: String): LiveData<Resource<PagedList<MoviesEntity>>> {
        return object : NetworkBoundResource<PagedList<MoviesEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<MoviesEntity>> {
                val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<MoviesEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getMovies()

            public override fun saveCallResult(movieResponse: List<MovieResponse>) {
                val movieList = ArrayList<MoviesEntity>()
                for (response in movieResponse) {
                    val movie = MoviesEntity(
                            response.moviesId,
                            response.title,
                            response.image,
                            response.date,
                            response.genre,
                            response.description,
                            response.director,
                            response.score,
                            false)
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(sort: String): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvResponse>>> =
                    remoteDataSource.getTvShow()

            public override fun saveCallResult(tvResponse: List<TvResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in tvResponse) {
                    val tvShow = TvShowEntity(
                            response.tvShowId,
                            response.title,
                            response.image,
                            response.date,
                            response.genre,
                            response.description,
                            response.kreator,
                            response.score,
                            false)
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }

        }.asLiveData()

    }

    override fun getDetailMovie(moviesId: String): LiveData<MoviesEntity> =
            localDataSource.getDetailMovie(moviesId)

    override fun getDetailTvShow(tvShowId: String): LiveData<TvShowEntity> =
            localDataSource.getDetailTvShow(tvShowId)

    override fun getListFavoriteMovies(): LiveData<PagedList<MoviesEntity>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        return LivePagedListBuilder(localDataSource.getListFavoriteMovie(), config).build()
    }

    override fun getListFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        return LivePagedListBuilder(localDataSource.getListFavoriteTvShow(), config).build()
    }

    override fun setFavoriteMovie(movie: MoviesEntity, newState: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setMoviesFavorite(movie, newState) }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, newState) }

}