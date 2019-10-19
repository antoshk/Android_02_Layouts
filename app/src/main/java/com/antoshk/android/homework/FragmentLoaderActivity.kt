package com.antoshk.android.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.antoshk.android.R
import com.antoshk.android.homework.fragment.MoviesFragment

class FragmentLoaderActivity: AppCompatActivity(), FragmentLoader{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.frame_container)

        loadFragment(MoviesFragment())
    }

    override fun getSupportManager(): FragmentManager {
        return supportFragmentManager
    }

    override fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, fragment)
            .commit()
    }

}