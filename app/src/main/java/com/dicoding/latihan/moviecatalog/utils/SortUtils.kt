package com.dicoding.latihan.moviecatalog.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {
    const val ASCENDING = "Ascending"
    const val DESCENDING = "Descending"
    const val DEFAULT = "Default"

    fun getSortedQueryMovie(filter: String) : SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM moviesentities ")
        if (filter == ASCENDING) {
            simpleQuery.append("ORDER BY title ASC")
        } else if (filter == DESCENDING) {
            simpleQuery.append("ORDER BY title DESC")
        } else if (filter == DEFAULT) {
            simpleQuery.append("ORDER BY moviesId ASC")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getSortedQueryTvShow(filter: String) : SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM tvshowentities ")
        if (filter == ASCENDING) {
            simpleQuery.append("ORDER BY title ASC")
        } else if (filter == DESCENDING) {
            simpleQuery.append("ORDER BY title DESC")
        } else if (filter == DEFAULT) {
            simpleQuery.append("ORDER BY tvShowId ASC")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}