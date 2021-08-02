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
import com.dicoding.latihan.moviecatalog.databinding.FragmentFavoriteMovieBinding
import com.dicoding.latihan.moviecatalog.ui.taskbar.FavoriteViewModel
import com.dicoding.latihan.moviecatalog.ui.taskbar.adapter.FavoriteMovieAdapter
import com.dicoding.latihan.moviecatalog.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteMovie : Fragment() {

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var mAdapter: FavoriteMovieAdapter

    private var favoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = favoriteMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        favoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onItemTouchHelper.attachToRecyclerView(binding?.favMovieRv)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            mAdapter = FavoriteMovieAdapter()
            binding?.progressBar?.visibility = View.VISIBLE
            viewModel.getListMovieFavorite().observe(viewLifecycleOwner, {moviesShow ->
                binding?.progressBar?.visibility = View.GONE
                mAdapter.submitList(moviesShow)
            })

            binding?.favMovieRv?.layoutManager = LinearLayoutManager(context)
            binding?.favMovieRv?.setHasFixedSize(true)
            binding?.favMovieRv?.adapter = mAdapter
        }
    }

    private val onItemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.RIGHT)


        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipePosition = viewHolder.adapterPosition
                val movieEntity = mAdapter.getSwipedData(swipePosition)
                movieEntity?.let { viewModel.setMovieFavorite(it) }

                val snackbar = Snackbar.make(view as View, "Batalkan Hapus Favorite Movie", Snackbar.LENGTH_LONG)
                snackbar.setAction("OK") {v ->
                    movieEntity?.let { viewModel.setMovieFavorite(it) }
                }
                snackbar.show()
            }
        }

    })

}