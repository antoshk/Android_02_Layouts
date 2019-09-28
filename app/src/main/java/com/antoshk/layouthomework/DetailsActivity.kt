package com.antoshk.layouthomework

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initToTrailerButton()
    }

    private fun initToTrailerButton(){
        val toTrailerButton: Button = findViewById(R.id.trailer_button)
        toTrailerButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=6ZfuNTqbHE8"))
            startActivity(intent)
        }
    }
}
