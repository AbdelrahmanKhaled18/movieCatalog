package com.example.myapplication3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class movie_service {

    companion object
    {
        private const val Base_url="https://api.themoviedb.org"
        private var retrofit:Retrofit? = null
        fun get_instance():Retrofit
        {
            if (retrofit == null)
            {
                retrofit=Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit!!

        }
    }
}