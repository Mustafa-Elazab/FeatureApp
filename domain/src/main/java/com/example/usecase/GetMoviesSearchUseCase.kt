package com.example.usecase

import com.example.model.Movie
import com.example.repository.Repository


class GetMoviesSearchUseCase(
    private val moviesRepository: Repository
) : UseCase.ResourceUseCase<List<Movie>> {

    companion object {
        const val QUERY_PARAM = "query"
    }

    override suspend fun executeAsync(param: Map<String, Any>?): Resource<List<Movie>> {
        return try {
            val movies = moviesRepository.getMoviesSearchAsync(param?.get(QUERY_PARAM).toString())
            if (movies.isEmpty()) return Resource.empty()
            Resource.success(movies)
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }
}