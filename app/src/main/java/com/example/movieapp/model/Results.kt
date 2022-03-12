package com.example.movieapp


import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("page") val page: Int,
  @SerializedName("results") val movies: List<Movies>,
  @SerializedName("total_pages") val pages: Int
)