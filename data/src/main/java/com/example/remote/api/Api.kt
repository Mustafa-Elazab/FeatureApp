package com.example.remote.api

import com.example.remote.dto.MovieListDTO
import com.example.remote.response.ErrorResponse
import com.example.remote.response.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("search/movie")
    suspend fun getMoviesSearch(
        @Query("api_key") api_key: String = "0d78a49b1a3056a1df36e1de7787fcda",
        @Query("query") query: String
    ): MovieListDTO

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String = "0d78a49b1a3056a1df36e1de7787fcda",
        @Query("page") page: Int
    ):MovieListDTO


}

typealias BaseResponse<S> = NetworkResponse<S, ErrorResponse>