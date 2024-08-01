package br.com.zup.mymoviesapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.mymoviesapp.api.RetrofitClient
import br.com.zup.mymoviesapp.model.DiscoverMoviesResponse
import br.com.zup.mymoviesapp.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val apiKey = "371887736991a9a6fd03227dbd3be941"
    private val accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzNzE4ODc3MzY5OTFhOWE2ZmQwMzIyN2RiZDNiZTk0MSIsIm5iZiI6MTcxOTg3NjQzMS4yNzEyNjksInN1YiI6IjY2ODMzYTljYzQ2YzBkZmRkMjIxZmE2YSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.N2n3PU7yadTL-KtFIVkbcS2Nnhbg9R1-9rscdo1XLtg"
    private val service = RetrofitClient.instance

    fun discoverMovies(page: Int) {
        val call = service.discoverMovies(page, apiKey, accessToken)
        call.enqueue(object : Callback<DiscoverMoviesResponse> {
            override fun onResponse(call: Call<DiscoverMoviesResponse>, response: Response<DiscoverMoviesResponse>) {
                if (response.isSuccessful) {
                    _movies.value = response.body()?.results
                    Log.d("MoviesViewModel", "Movies: ${response.body()?.results}")
                }
            }

            override fun onFailure(call: Call<DiscoverMoviesResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}