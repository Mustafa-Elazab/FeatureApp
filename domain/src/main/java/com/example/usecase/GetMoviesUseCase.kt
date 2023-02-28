package com.example.usecase


import com.example.model.Movie
import com.example.repository.Repository
import kotlinx.coroutines.flow.flow

class GetMoviesUseCase(
    private val moviesRepository: Repository
)  {

   operator fun invoke() = flow {
       emit(moviesRepository.getPopularMovies())
   }
}