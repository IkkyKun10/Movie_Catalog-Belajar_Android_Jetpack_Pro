package com.dicoding.latihan.moviecatalog.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.databinding.FragmentMovieShowBinding
import com.dicoding.latihan.moviecatalog.ui.taskbar.HomeFavorite
import com.dicoding.latihan.moviecatalog.utils.SortUtils
import com.dicoding.latihan.moviecatalog.viewmodel.ViewModelFactory
import com.dicoding.latihan.moviecatalog.vo.Status

class MovieShowFragment : Fragment() {

    private var fragmentMovieBinding : FragmentMovieShowBinding? = null
    private val binding get() = fragmentMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var mAdapter: MovieShowAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentMovieBinding = FragmentMovieShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            mAdapter = MovieShowAdapter()

            viewModel.getMovies(SortUtils.DEFAULT).observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            mAdapter.submitList(movies.data)
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Gagal Memuat Data", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvMovieShow){
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = mAdapter
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.fav_destinasi -> {
                val intent = Intent(context, HomeFavorite::class.java)
                startActivity(intent)
            }
            R.id.action_asc -> sort = SortUtils.ASCENDING
            R.id.action_desc -> sort = SortUtils.DESCENDING
            R.id.action_default -> sort = SortUtils.DEFAULT
        }
        viewModel.getMovies(sort).observe(this, {movies ->
            if (movies != null) {
                mAdapter.submitList(movies.data)
            }
        })
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMovieBinding = null
    }

}