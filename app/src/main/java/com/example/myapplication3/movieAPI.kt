package com.example.myapplication3

import retrofit2.Call
import retrofit2.http.GET

interface movieAPI {
    @GET("/3/movie/popular?api_key=356270bcfb667637942612221b114483")
    fun get_movie_list(): Call<movie_response>
}