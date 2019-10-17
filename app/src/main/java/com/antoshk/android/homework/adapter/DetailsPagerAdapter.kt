package com.antoshk.android.homework.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.antoshk.android.homework.fragment.DetailsFragment
import com.antoshk.android.homework.repository.MovieRepo

class DetailsPagerAdapter(fm: FragmentManager, private val pageCount: Int) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = pageCount

    override fun getItem(position: Int): Fragment = DetailsFragment.newInstance(MovieRepo.movies[position])
}