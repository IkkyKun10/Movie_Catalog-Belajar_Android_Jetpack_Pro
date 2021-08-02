package com.dicoding.latihan.moviecatalog.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.ui.movie.MovieShowFragment
import com.dicoding.latihan.moviecatalog.ui.tv.TvShowFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie_show, R.string.tv_show)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieShowFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

}