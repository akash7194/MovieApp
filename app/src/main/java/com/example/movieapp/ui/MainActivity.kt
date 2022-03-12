package com.example.movieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.Movies
import com.example.movieapp.R
import com.example.movieapp.Results
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.network.MovieRepo

class MainActivity : AppCompatActivity() {

//    private lateinit var  binding:
    private  lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding= ActivityMainBinding.inflate(layoutInflater)
       setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.rcecycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        adapter= MoviesAdapter(listOf())
        MovieRepo.getPopularMovies(1)
       // todo create callback for repo
        //and then
       // adapter.updateMovies()


    }
}