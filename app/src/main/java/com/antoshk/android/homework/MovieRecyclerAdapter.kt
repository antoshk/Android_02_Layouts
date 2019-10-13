package com.antoshk.android.homework

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antoshk.android.R
import com.antoshk.android.homework.repository.Movie
import com.bumptech.glide.Glide

class MovieRecyclerAdapter(
    context: Context,
    var movies: List<Movie>
) : RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    var onClick:(movie: Movie) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.movie_row, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClick)
        setFadeAnimation(holder.itemView)
    }

    private fun getItem(position: Int): Movie = movies[position]

    private fun setFadeAnimation(view: View) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 400
        view.startAnimation(animation)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val poster: ImageView = itemView.findViewById(R.id.poster)
        private val movieName: TextView = itemView.findViewById(R.id.movie_name)
        private val description: TextView = itemView.findViewById(R.id.movie_description)

        fun bind(movie: Movie, onClick:(movie: Movie) -> Unit = {}) {
            Glide
                .with(itemView)
                .load(movie.posterUri)
                .into(poster)

            movieName.text = movie.name
            description.text = movie.description

            itemView.setOnClickListener {
                onClick.invoke(movie)
                //Toast.makeText(itemView.context, movie.name + " selected", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

