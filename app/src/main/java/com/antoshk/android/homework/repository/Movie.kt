package com.antoshk.android.homework.repository

import java.io.Serializable

data class Movie(
    val name: String,
    val posterURI: String,
    val description: String
) : Serializable

