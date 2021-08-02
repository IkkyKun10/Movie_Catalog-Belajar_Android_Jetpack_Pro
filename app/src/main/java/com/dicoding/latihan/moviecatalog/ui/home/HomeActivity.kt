package com.dicoding.latihan.moviecatalog.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.latihan.moviecatalog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private var activityHomeBinding: ActivityHomeBinding? = null
    private val binding get() = activityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionPagerAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)

        supportActionBar?.elevation = 0f
    }

}