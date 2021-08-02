package com.dicoding.latihan.moviecatalog.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.databinding.ItemMovieShowBinding
import com.dicoding.latihan.moviecatalog.ui.detail.DetailMovies

class MovieShowAdapter : PagedListAdapter<MoviesEntity, MovieShowAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :DiffUtil.ItemCallback<MoviesEntity>() {
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.moviesId == newItem.moviesId
            }

            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class MovieViewHolder(private val binding: ItemMovieShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemDate.text = movie.date
                tvItemDescription.text = movie.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovies::class.java)
                    intent.putExtra(DetailMovies.EXTRA_MOVIES, movie.moviesId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                        .load(movie.image)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_broken_image_black)
                        .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieShowAdapter.MovieViewHolder {
        val itemMovieBinding = ItemMovieShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieShowAdapter.MovieViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

}