package com.antoshk.android.homework

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.antoshk.android.R
import com.antoshk.android.homework.repository.Movie
import com.bumptech.glide.Glide

const val MOVIE_DATA = "MovieData"

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initTrailerButton()
        val movie: Movie = intent.getSerializableExtra(MOVIE_DATA) as Movie
        findViewById<TextView>(R.id.movie_title).text = movie.name
        findViewById<TextView>(R.id.overview_content).text = movie.description
        val poster = findViewById<ImageView>(R.id.poster)
        Glide
            .with(this)
            .load(movie.posterUri)
            .into(poster)
    }

    private fun initTrailerButton(){
        val toTrailerButton: Button = findViewById(R.id.trailer_button)
        toTrailerButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=6ZfuNTqbHE8"))
            startActivity(intent)
        }
    }
}
