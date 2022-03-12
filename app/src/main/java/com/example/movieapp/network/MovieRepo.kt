package com.example.movieapp.network

import android.util.Log
import com.example.movieapp.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepo {
    //object because singleton

    private val api:RetrofitService

    init {
        val retrofit=Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api=retrofit.create(RetrofitService::class.java)
    }

    fun getPopularMovies(page: Int = 1) {
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<Results> {
                override fun onResponse(
                    call: Call<Results>,
                    response: Response<Results>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            Log.d("AKASH", "Movies: ${responseBody.movies}")
                        } else {
                            Log.d("AKASH", "Failure")
                        }
                    }
                }

                override fun onFailure(call: Call<Results>, t: Throwable) {
                    Log.e("AKASH", "onFailure", t)
                }
            })
    }
}