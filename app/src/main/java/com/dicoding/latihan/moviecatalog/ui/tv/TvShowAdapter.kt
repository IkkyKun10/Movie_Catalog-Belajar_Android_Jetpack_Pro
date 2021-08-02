package com.dicoding.latihan.moviecatalog.ui.tv

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
import com.dicoding.latihan.moviecatalog.databinding.ItemTvShowBinding
import com.dicoding.latihan.moviecatalog.ui.detail.DetailMovies

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.TvViewHolder>(DIFF_CALLBACK) {

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

    class TvViewHolder(private val binding: ItemTvShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity){
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDate.text = tvShow.date
                tvItemDescription.text = tvShow.description
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovies::class.java)
                    intent.putExtra(DetailMovies.EXTRA_TV, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                        .load(tvShow.image)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                        .error(R.drawable.ic_error)
                        .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val tvShowBinding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(tvShowBinding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

}