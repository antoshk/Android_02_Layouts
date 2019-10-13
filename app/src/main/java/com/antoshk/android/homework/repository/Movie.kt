package com.antoshk.android.homework.repository

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    val name: String,
    val posterUri: String,
    val topImageUri: String,
    val description: String,
    val releaseDate: String,
    val trailerUri: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(posterUri)
        parcel.writeString(topImageUri)
        parcel.writeString(description)
        parcel.writeString(releaseDate)
        parcel.writeString(trailerUri)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

