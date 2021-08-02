package com.dicoding.latihan.moviecatalog.ui.tv

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.databinding.FragmentTvShowBinding
import com.dicoding.latihan.moviecatalog.ui.taskbar.HomeFavorite
import com.dicoding.latihan.moviecatalog.utils.SortUtils
import com.dicoding.latihan.moviecatalog.viewmodel.ViewModelFactory
import com.dicoding.latihan.moviecatalog.vo.Status

class TvShowFragment : Fragment() {

    private var fragmentTvBinding : FragmentTvShowBinding? = null
    private val binding get() = fragmentTvBinding
    private lateinit var viewModel: TvViewModel
    private lateinit var tAdapter: TvShowAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentTvBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvViewModel::class.java]
            tAdapter = TvShowAdapter()

            viewModel.getTvShow(SortUtils.DEFAULT).observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when (tvShow.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            tAdapter.submitList(tvShow.data)
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Gagal Memuat Data", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(binding?.rvTvShow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tAdapter
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
        viewModel.getTvShow(sort).observe(this, {tvShow ->
            if (tvShow != null) {
                tAdapter.submitList(tvShow.data)
            }
        })

        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentTvBinding = null
    }
}