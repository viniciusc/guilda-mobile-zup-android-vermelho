package br.com.zup.mymoviesapp.model

data class DiscoverMoviesResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)