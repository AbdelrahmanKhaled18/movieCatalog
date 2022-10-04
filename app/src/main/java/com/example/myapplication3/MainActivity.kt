package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_movies_list.layoutManager=LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        get_movie_data {
                movies : List<Movie> ->
            rv_movies_list.adapter = movie_adapter(movies)
        }
    }
    private fun get_movie_data(callback: (List<Movie>) -> Unit){
        val apiService = movie_service.get_instance().create(movieAPI::class.java)
        apiService.get_movie_list().enqueue(object : Callback<movie_response> {
            override fun onFailure(call: Call<movie_response>, t: Throwable) {

            }

            override fun onResponse(call: Call<movie_response>, response: Response<movie_response>) {
                return callback(response.body()!!.movies)
            }

        })
    }
}