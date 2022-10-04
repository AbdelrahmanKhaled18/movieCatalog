package com.example.myapplication3

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class movie_response (@SerializedName("results") val movies:List<Movie>):Parcelable
{
    constructor():this (mutableListOf())
}