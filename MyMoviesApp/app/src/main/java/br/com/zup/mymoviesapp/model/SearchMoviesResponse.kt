package br.com.zup.mymoviesapp.model

data class SearchMoviesResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)