package com.antoshk.android.homework

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.antoshk.android.R
import com.antoshk.android.homework.repository.Movie
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {

    companion object {
        private const val MOVIE_STORAGE = "MOVIE_STORAGE"

        fun newInstance(movie: Movie): DetailsFragment {
            val fragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putParcelable(MOVIE_STORAGE, movie)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.activity_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Movie>(MOVIE_STORAGE)?.run {
            view.findViewById<TextView>(R.id.movie_title).text = name
            view.findViewById<TextView>(R.id.overview_content).text = description
            view.findViewById<TextView>(R.id.released_date).text = releaseDate
            val poster = view.findViewById<ImageView>(R.id.poster)
            Glide
                .with(view)
                .load(posterUri)
                .into(poster)
            val topImage = view.findViewById<ImageView>(R.id.top_image)
            Glide
                .with(view)
                .load(topImageUri)
                .into(topImage)
            val trailerButton: Button = view.findViewById(R.id.trailer_button)
            trailerButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(trailerUri))
                startActivity(intent)
            }
        }

    }

}