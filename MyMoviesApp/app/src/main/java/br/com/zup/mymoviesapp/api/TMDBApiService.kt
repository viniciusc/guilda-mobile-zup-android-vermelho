package br.com.zup.mymoviesapp.api

import br.com.zup.mymoviesapp.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBApiService {
    @GET("3/discover/movie")
    fun discoverMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String,
        @Query("access_token") accessToken: String
    ): Call<DiscoverMoviesResponse>

    @GET("3/search/movie")
    fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String,
        @Query("access_token") accessToken: String
    ): Call<SearchMoviesResponse>

    @GET("3/movie/{movieId}")
    fun getMovieDetails(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("access_token") accessToken: String
    ): Call<MovieDetailsResponse>

    @GET("3/configuration")
    fun getConfiguration(
        @Query("api_key") apiKey: String,
        @Query("access_token") accessToken: String
    ): Call<ConfigurationResponse>
}