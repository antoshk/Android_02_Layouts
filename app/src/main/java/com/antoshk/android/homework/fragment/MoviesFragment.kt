package com.antoshk.android.homework.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoshk.android.R
import com.antoshk.android.homework.FragmentLoader
import com.antoshk.android.homework.adapter.MovieRecyclerAdapter
import com.antoshk.android.homework.repository.MovieRepo

class MoviesFragment : Fragment() {

    private var fragmentLoader: FragmentLoader? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.activity_movies, container, false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FragmentLoader) {
            fragmentLoader = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = view.findViewById<RecyclerView>(R.id.movieList)
        val movies = MovieRepo.movies
        val adapter = MovieRecyclerAdapter(view.context, movies)
        adapter.onClick = {
            val currentPos = movies.indexOf(it)
            fragmentLoader?.loadFragment(DetailsSliderFragment.getInstance(currentPos))
        }
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(view.context)

        val decoration = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        list.addItemDecoration(decoration)

    }

}
