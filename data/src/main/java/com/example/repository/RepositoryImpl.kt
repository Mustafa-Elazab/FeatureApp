package com.example.repository

import com.example.mapper.toMovie
import com.example.model.Movie
import com.example.remote.api.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val api: Api) : Repository {


    private var page: Int = 0
    private var totalPages: Int = 1


    override suspend fun getPopularMovies(): List<Movie> {
        if (page > totalPages)
            page += 1
        val response = api.getPopularMovies("0d78a49b1a3056a1df36e1de7787fcda", page)
        response.totalPages.let {
            totalPages = it!!
        }
        return response.movies.map {
            it.toMovie()
        }
        return listOf()
    }

    override suspend fun getMoviesSearch(query: String): List<Movie> {
        return api.getMoviesSearch("0d78a49b1a3056a1df36e1de7787fcda", query).movies.map {
            it.toMovie()
        }
    }


}