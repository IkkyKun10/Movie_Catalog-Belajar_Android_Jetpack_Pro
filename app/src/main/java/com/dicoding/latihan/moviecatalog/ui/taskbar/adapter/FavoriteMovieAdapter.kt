package com.dicoding.latihan.moviecatalog.ui.taskbar.adapter

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
import com.dicoding.latihan.moviecatalog.databinding.ItemFavoriteMovieBinding
import com.dicoding.latihan.moviecatalog.ui.detail.DetailMovies

class FavoriteMovieAdapter : PagedListAdapter<MoviesEntity, FavoriteMovieAdapter.MovieViewHolder>(
    DIFF_CALLBACK
) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MoviesEntity>() {
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.moviesId == newItem.moviesId
            }

            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    class MovieViewHolder(private val binding: ItemFavoriteMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                tvItemTitle.text = movies.title
                tvItemDescription.text = movies.description
                tvItemDate.text = movies.date
                cvItemFav.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovies::class.java)
                    intent.putExtra(DetailMovies.EXTRA_MOVIES, movies.moviesId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(movies.image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_broken_image_black)
                    .into(imgPoster)
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): MoviesEntity? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemFavoriteMovieBinding = ItemFavoriteMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemFavoriteMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null){
            holder.bind(movie)
        }
    }
}