package com.example.movieapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.Movies
import com.example.movieapp.R

class MoviesAdapter(private  var movies : List<Movies>) :RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val  viewItem = LayoutInflater.from(parent.context).inflate(R.layout.movies_item_layout,parent,false)
        return MovieViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
      holder.bind(movies.get(position));
    }

    override fun getItemCount(): Int {
       return  movies.size
    }
    fun updateMovies(movies: List<Movies>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(item: View):RecyclerView.ViewHolder(item) {
        private val poste: ImageView=item.findViewById(R.id.image_movie_item)
        private val title: TextView=item.findViewById(R.id.title_movie_item)
        private val desc: TextView=item.findViewById(R.id.desc)

        fun bind(movie: Movies) {
           title.setText(movie.title)
            desc.setText(movie.overview)
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/original${movie.backdropPath}")
                .into(poste)
        }

    }
}