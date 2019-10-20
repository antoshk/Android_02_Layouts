package com.antoshk.android.homework.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoshk.android.R
import com.antoshk.android.homework.FragmentLoader
import com.antoshk.android.homework.adapter.MovieRecyclerAdapter
import com.antoshk.android.homework.repository.MovieRepo
import com.antoshk.android.homework.thread.factory.CoroutineTaskFactory
import com.antoshk.android.homework.thread.factory.JavaTreadsTaskFactory


class MoviesFragment : Fragment() {

    private var fragmentLoader: FragmentLoader? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.activity_movies, container, false)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentLoader) {
            fragmentLoader = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentLoader = null
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

        processMenu(view)

    }

    private fun processMenu(view: View){
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.threads_menu)

        toolbar.setOnMenuItemClickListener {
            when (it.itemId){
                R.id.menuCoroutines -> {
                    fragmentLoader?.loadFragment(TreadsFragment.newInstance(CoroutineTaskFactory()))
                    true
                }
                R.id.menuThreads -> {
                    fragmentLoader?.loadFragment(TreadsFragment.newInstance(JavaTreadsTaskFactory()))
                    true
                }
                else -> {
                    super.onOptionsItemSelected(it)
                }
            }
        }
    }

}
