package com.example.movieapp.network

import android.support.compat.BuildConfig
import com.example.movieapp.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "38a73d59546aa378980a88b645f487fc",
        @Query("page") page: Int
    ): Call<Results>
}