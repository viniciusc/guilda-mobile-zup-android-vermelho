package br.com.zup.mymoviesapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.mymoviesapp.API_KEY
import br.com.zup.mymoviesapp.API_READ_ACCESS_TOKEN
import br.com.zup.mymoviesapp.api.RetrofitClient
import br.com.zup.mymoviesapp.model.DiscoverMoviesResponse
import br.com.zup.mymoviesapp.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    private val service = RetrofitClient.instance

    fun discoverMovies(page: Int) {
        val call = service.discoverMovies(page, API_KEY, API_READ_ACCESS_TOKEN)
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