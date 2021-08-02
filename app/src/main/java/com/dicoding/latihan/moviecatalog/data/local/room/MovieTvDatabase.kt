package com.dicoding.latihan.moviecatalog.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity

@Database(entities = [MoviesEntity::class, TvShowEntity::class], version = 1, exportSchema = false)
abstract class MovieTvDatabase : RoomDatabase() {
    abstract fun movieTvDao() : MovieTvDao
    companion object {

        @Volatile
        private var INSTANCE : MovieTvDatabase? = null

        fun getInstance(context: Context) : MovieTvDatabase {
            if (INSTANCE == null) {
                synchronized(MovieTvDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                        MovieTvDatabase::class.java, "CatalogMovie.db")
                                .build()
                    }
                }
            }
            return INSTANCE as MovieTvDatabase
        }
    }
}