package com.example.mapper

import com.example.model.Movie
import com.example.model.MovieList
import com.example.remote.api.BaseResponse
import com.example.remote.dto.MovieDTO
import com.example.remote.dto.MovieListDTO

fun MovieDTO.toMovie() = Movie(
    id = id,
    title = title,
    adult = adult,
    backdropPath = backdropPath,
    genreIds = genreIds,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    releaseDate = releaseDate,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)

fun MovieListDTO.toMovieList() = MovieList(
    page,
    movies.map {
        it.toMovie()
    },
    totalPages,
    totalResults
)

