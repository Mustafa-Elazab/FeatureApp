package com.example.model



data class MovieList(

    var page: Int? = null,

    var movies: List<Movie> = arrayListOf(),

    var totalPages: Int? = null,

    var totalResults : Int? = null
)

data class Movie(
    var id: Int,
    var title: String? = null,
    var adult: Boolean? = null,
    var backdropPath: String?  = null,
    var genreIds: List<Int> = arrayListOf(),
    var originalLanguage: String? = null,
    var originalTitle: String? = null,
    var overview: String? = null,
    var popularity: Double? = null,
    var posterPath: String? = null,
    var releaseDate: String? = null,
    var video: Boolean? = null,
    var voteAverage: Double? = null,
    var voteCount: Int? = null
) 