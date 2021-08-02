package com.dicoding.latihan.moviecatalog.utils

import android.content.Context
import com.dicoding.latihan.moviecatalog.data.remote.response.MovieResponse
import com.dicoding.latihan.moviecatalog.data.remote.response.TvResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovie() :List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("moviesId")
                val title = movie.getString("title")
                val image = movie.getString("image")
                val date = movie.getString("date")
                val description = movie.getString("description")
                val genre = movie.getString("genre")
                val director = movie.getString("director")
                val score = movie.getString("score")

                val movieResponse = MovieResponse(id, title, image, date, genre, description, director, score)
                list.add(movieResponse)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow() : List<TvResponse> {
        val list = ArrayList<TvResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("tvShow")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("tvShowId")
                val title = tvShow.getString("title")
                val image = tvShow.getString("image")
                val date = tvShow.getString("date")
                val description = tvShow.getString("description")
                val genre = tvShow.getString("genre")
                val kreator = tvShow.getString("kreator")
                val score = tvShow.getString("score")

                val tvResponse = TvResponse(id, title, image, date, genre, description, kreator, score)
                list.add(tvResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list

    }

}