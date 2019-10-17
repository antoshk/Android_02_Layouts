package com.antoshk.android.homework.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.antoshk.android.R
import com.antoshk.android.homework.adapter.DetailsPagerAdapter
import com.antoshk.android.homework.page_transformer.ZoomOutPageTransformer
import com.antoshk.android.homework.repository.MovieRepo

class DetailsSliderFragment : Fragment() {

    private lateinit var mPager: ViewPager

    companion object {
        private const val CURRENT_POS = "CURRENT_POS"

        fun getInstance(currentPosition: Int): DetailsSliderFragment {
            val fragment = DetailsSliderFragment()
            val bundle = Bundle()
            bundle.putInt(CURRENT_POS, currentPosition)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.activity_details_slider, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position: Int = arguments?.getInt(CURRENT_POS, 1) ?: 1
        mPager = view.findViewById(R.id.details_pager)

        val pagerAdapter = DetailsPagerAdapter(childFragmentManager, MovieRepo.movies.size)
        mPager.adapter = pagerAdapter
        mPager.currentItem = position
        mPager.setPageTransformer(true, ZoomOutPageTransformer())

    }

}
