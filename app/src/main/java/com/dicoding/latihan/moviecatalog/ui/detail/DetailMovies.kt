package com.dicoding.latihan.moviecatalog.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.databinding.ActivityDetailMoviesBinding
import com.dicoding.latihan.moviecatalog.viewmodel.ViewModelFactory

class DetailMovies : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    private var activityDetailBinding : ActivityDetailMoviesBinding? = null

    private val mainBinding get() = activityDetailBinding
    private val detailContenBinding get() = activityDetailBinding?.detailContent

    private lateinit var viewModel: DetailFilmViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailMoviesBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)

        setSupportActionBar(mainBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailFilmViewModel::class.java]

        intent.extras.let {
            it?.getString(EXTRA_MOVIES)?.apply {
                mainBinding?.progressBar?.visibility = View.VISIBLE
                mainBinding?.contents?.visibility = View.INVISIBLE
                viewModel.setSelectedMovie(this)
                supportActionBar?.title = "Movie Detail"

                viewModel.movies.observe(this@DetailMovies, {movies ->
                    if (movies != null) {
                        mainBinding?.progressBar?.visibility = View.GONE
                        mainBinding?.contents?.visibility = View.VISIBLE
                        dataMovies(movies)
                    }
                })
            }
            it?.getString(EXTRA_TV)?.apply {
                mainBinding?.progressBar?.visibility = View.VISIBLE
                mainBinding?.contents?.visibility = View.INVISIBLE
                viewModel.setSelectedTv(this)
                supportActionBar?.title = "Tv Shows Detail"

                viewModel.tvShow.observe(this@DetailMovies, {tvShow ->
                    if (tvShow != null) {
                        mainBinding?.progressBar?.visibility = View.GONE
                        mainBinding?.contents?.visibility = View.VISIBLE
                        dataTvshows(tvShow)
                    }
                })
            }
        }

    }

    private fun dataMovies(movies: MoviesEntity) {
        detailContenBinding?.txtTitle?.text = movies.title
        detailContenBinding?.txtDate?.text = movies.date
        detailContenBinding?.txtGenre?.text = movies.genre
        detailContenBinding?.txtDirector?.text = movies.director
        detailContenBinding?.txtScore?.text = movies.score
        detailContenBinding?.txtDesc?.text = movies.description

        detailContenBinding?.imgDetail?.let {
            Glide.with(this)
                .load(movies.image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(it)
        }
    }

    private fun dataTvshows(tvShows: TvShowEntity) {
        detailContenBinding?.txtTitle?.text = tvShows.title
        detailContenBinding?.txtDate?.text = tvShows.date
        detailContenBinding?.txtGenre?.text = tvShows.genre
        detailContenBinding?.txtDirector?.text = tvShows.kreator
        detailContenBinding?.txtScore?.text = tvShows.score
        detailContenBinding?.txtDesc?.text = tvShows.description

        detailContenBinding?.imgDetail?.let {
            Glide.with(this)
                .load(tvShows.image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_error)
                .into(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fav_detail, menu)
        this.menu = menu
        viewModel.movies.observe(this, {movies ->
            if (movies != null) {
                val state = movies.favorite
                setFavorite(state)
            }
        })
        viewModel.tvShow.observe(this, {tvShows ->
            if (tvShows != null) {
                val state = tvShows.favorite
                setFavorite(state)
            }
        })

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fav_detail -> {
                viewModel.setFavoriteMovie()
                viewModel.setFavoriteTv()
            }
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }

    private fun setFavorite(state: Boolean) {
        if (menu == null) return
        val menuFav = menu?.findItem(R.id.fav_detail)
        if (state) {
            menuFav?.icon = ContextCompat.getDrawable(this, R.drawable.favorite)
        } else {
            menuFav?.icon = ContextCompat.getDrawable(this, R.drawable.favorite_border)
        }
    }
}