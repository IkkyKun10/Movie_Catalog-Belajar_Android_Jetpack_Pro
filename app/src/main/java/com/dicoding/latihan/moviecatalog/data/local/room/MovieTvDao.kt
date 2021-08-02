package com.dicoding.latihan.moviecatalog.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity

@Dao
interface MovieTvDao {

    @RawQuery(observedEntities = [MoviesEntity::class])
    fun getAllMovies(query: SupportSQLiteQuery) : DataSource.Factory<Int, MoviesEntity>

    @RawQuery(observedEntities = [TvShowEntity::class])
    fun getAllTvShow(query: SupportSQLiteQuery) : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM moviesentities where favorite = 1")
    fun getListFavoriteMovie() : DataSource.Factory<Int, MoviesEntity>

    @Query("SELECT * FROM tvshowentities where favorite = 1")
    fun getListFavoriteTvShow() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM moviesentities where moviesId = :moviesId")
    fun getDetailMovies(moviesId: String) : LiveData<MoviesEntity>

    @Query("SELECT * FROM tvshowentities where tvShowId = :tvShowId")
    fun getDetailTvShow(tvShowId: String) : LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MoviesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateMovies(movies: MoviesEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}