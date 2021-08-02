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
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.databinding.ItemFavoriteTvBinding
import com.dicoding.latihan.moviecatalog.ui.detail.DetailMovies

class FavoriteTvShowAdapter : PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvShowId == newItem.tvShowId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    class TvShowViewHolder(private val binding: ItemFavoriteTvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDescription.text = tvShow.description
                tvItemDate.text = tvShow.date
                cvItemFav.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovies::class.java)
                    intent.putExtra(DetailMovies.EXTRA_TV, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_broken_image_black)
                    .into(imgPoster)
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemFavoriteTvBinding = ItemFavoriteTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemFavoriteTvBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }
}
