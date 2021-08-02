package com.dicoding.latihan.moviecatalog.ui.taskbar

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.latihan.moviecatalog.R
import com.dicoding.latihan.moviecatalog.ui.taskbar.fragment.FavoriteMovie
import com.dicoding.latihan.moviecatalog.ui.taskbar.fragment.FavoriteTvShow

class SectionPagerAdapterFav(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TAB_TITLE = intArrayOf(R.string.movie_show, R.string.tv_show)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovie()
            1 -> FavoriteTvShow()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLE[position])
    }
}