package com.antoshk.android.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.antoshk.android.R
import com.antoshk.android.homework.page_transformer.ZoomOutPageTransformer
import com.antoshk.android.homework.repository.MovieRepo

const val MOVIE_POS = "MoviePos"

class DetailsActivity : FragmentActivity() {

    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_slider)

        val position: Int = intent.getIntExtra(MOVIE_POS, 1)

        mPager = findViewById(R.id.details_pager)
        val pagerAdapter = DetailsPagerAdapter(supportFragmentManager, MovieRepo.movies.size)
        mPager.adapter = pagerAdapter
        mPager.currentItem = position
        mPager.setPageTransformer(true, ZoomOutPageTransformer())

    }

    private inner class DetailsPagerAdapter(fm: FragmentManager, private val pageCount: Int) : FragmentStatePagerAdapter(fm) {

        override fun getCount(): Int = pageCount

        override fun getItem(position: Int): Fragment = DetailsFragment.newInstance(MovieRepo.movies[position])
    }
}
