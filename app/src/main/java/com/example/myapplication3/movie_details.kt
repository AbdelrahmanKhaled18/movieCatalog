package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.film_item.view.*

class movie_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        val movie=intent.getParcelableExtra<Movie>("Movie")

        if(movie!=null)
        {
            val image_base="https://image.tmdb.org/t/p/w500/"
            val film_image_2:ImageView=findViewById(R.id.film_image_2)
            val film_name_2:TextView=findViewById(R.id.film_name_label_2)
            val original_language_2:TextView=findViewById(R.id.original_language_2)
            original_language_2.text =movie.language
            val popularity_2:TextView=findViewById(R.id.popularity_2)
            popularity_2.text=movie.popularity.toString()+"  Dollars  per week internationally "
            val movie_overView:TextView=findViewById(R.id.movie_overview_2)
            movie_overView.text=movie.overview
            Glide.with(film_image_2).load( image_base+movie.poster).into(film_image_2)
            film_name_2.text=movie.title





        }

    }
}