package com.example.myapplication3
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.film_item.view.*

class movie_adapter(private val movies:List<Movie>
):RecyclerView.Adapter<movie_adapter.movie_view_holder>() {
    var onItemClick: ((Movie)->Unit)?=null


    inner class movie_view_holder(view: View):RecyclerView.ViewHolder(view)
     {
        private val image_base= "https://image.tmdb.org/t/p/w500/"
        fun bind_movies(movie: Movie)
        {
            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.release_date
            Glide.with(itemView).load(image_base + movie.poster).into(itemView.movie_poster)
            itemView.movie_poster.setOnClickListener {
                val current_film=movies[layoutPosition]
                val intent=Intent(itemView.context,movie_details::class.java)
                intent.putExtra("Movie",current_film)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movie_view_holder {
       return movie_view_holder(LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false))
    }

    override fun onBindViewHolder(holder: movie_view_holder, position: Int) {
       val current_film=movies[position]
        holder.bind_movies(current_film)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(current_film)
        }
    }

    override fun getItemCount(): Int =movies.size




}