package com.dicoding.latihan.moviecatalog.ui.taskbar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.latihan.moviecatalog.databinding.FragmentFavoriteTvBinding
import com.dicoding.latihan.moviecatalog.ui.taskbar.FavoriteViewModel
import com.dicoding.latihan.moviecatalog.ui.taskbar.adapter.FavoriteTvShowAdapter
import com.dicoding.latihan.moviecatalog.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteTvShow : Fragment() {

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var tAdapter: FavoriteTvShowAdapter

    private var favoriteTvShowBinding: FragmentFavoriteTvBinding? = null
    private val binding get() = favoriteTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        favoriteTvShowBinding = FragmentFavoriteTvBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onItemTouchHelper.attachToRecyclerView(binding?.favTvshowRv)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            tAdapter = FavoriteTvShowAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getListTvShowFavorite().observe(viewLifecycleOwner, {tvShows ->
                binding?.progressBar?.visibility = View.GONE
                tAdapter.submitList(tvShows)
            })

            binding?.favTvshowRv?.layoutManager = LinearLayoutManager(context)
            binding?.favTvshowRv?.setHasFixedSize(true)
            binding?.favTvshowRv?.adapter = tAdapter
        }
    }

    private val onItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipePosition = viewHolder.adapterPosition
                val tvShowEntity = tAdapter.getSwipedData(swipePosition)
                tvShowEntity?.let { viewModel.setTvShowFavorite(it) }

                val snackbar = Snackbar.make(view as View, "Batalkan Hapus Favorite Tv Show", Snackbar.LENGTH_LONG)
                snackbar.setAction("OK") {v ->
                    tvShowEntity?.let { viewModel.setTvShowFavorite(it) }
                }
                snackbar.show()
            }
        }

    })

}