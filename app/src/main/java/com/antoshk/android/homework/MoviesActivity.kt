package com.antoshk.android.homework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoshk.android.R
import com.antoshk.android.homework.repository.MovieRepo

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val list = findViewById<RecyclerView>(R.id.movieList)
        val movies = MovieRepo.movies
        val adapter = MovieRecyclerAdapter(this, movies)
        adapter.onClick = {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(MOVIE_POS, movies.indexOf(it))
            startActivity(intent)
        }
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        list.addItemDecoration(decoration)

    }


}
