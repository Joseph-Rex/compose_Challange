package com.example.compose_challange.ui.theme.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("https://api.themoviedb.org/3/movie/{category}/?api_key=70af851c6b659458ba8a2b5ce360424d")
    suspend fun getMoviesBasedOnCategories(
        @Path("category") category: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResult

}