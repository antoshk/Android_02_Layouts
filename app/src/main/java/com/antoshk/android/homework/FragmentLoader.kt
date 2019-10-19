package com.antoshk.android.homework

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface FragmentLoader {
    fun loadFragment(fragment: Fragment)

    fun getSupportManager(): FragmentManager
}