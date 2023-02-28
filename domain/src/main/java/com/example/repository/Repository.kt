package com.example.repository


import com.example.model.Movie
import com.example.model.MovieList
import com.example.usecase.Resource

interface Repository {

    suspend fun getPopularMovies(): List<Movie>
    suspend fun getMoviesSearch(query: String): List<Movie>
}

