package com.antoshk.android.homework

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoshk.android.R
import com.antoshk.android.homework.repository.MovieRepo

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val list = findViewById<RecyclerView>(R.id.movieList)
        val movies = MovieRepo().generateMovies()
        val adapter = MovieRecyclerAdapter(this, movies)
        adapter.onClick = {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("MovieData", it)
            startActivity(intent)
        }
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

    }


}
