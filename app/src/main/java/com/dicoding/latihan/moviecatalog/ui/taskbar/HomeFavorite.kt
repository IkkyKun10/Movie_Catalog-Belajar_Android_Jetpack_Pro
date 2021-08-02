package com.dicoding.latihan.moviecatalog.ui.taskbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.dicoding.latihan.moviecatalog.databinding.ActivityHomeFavoriteBinding

class HomeFavorite : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeFavorite = ActivityHomeFavoriteBinding.inflate(layoutInflater)
        setContentView(activityHomeFavorite.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = 0f
        supportActionBar?.title = "Favorite"

        val sectionPagerAdapterFav = SectionPagerAdapterFav(this, supportFragmentManager)
        activityHomeFavorite.viewpagerFav.adapter = sectionPagerAdapterFav
        activityHomeFavorite.tabsFav.setupWithViewPager(activityHomeFavorite.viewpagerFav)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }
}