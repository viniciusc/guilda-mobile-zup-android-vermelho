package br.com.zup.mymoviesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.zup.mymoviesapp.ui.theme.MyMoviesAppTheme
import br.com.zup.mymoviesapp.viewmodel.MoviesViewModel
import androidx.lifecycle.Observer

class MainActivity : ComponentActivity() {
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moviesViewModel.movies.observe(this, Observer { movies ->
            Log.d("MainActivity", "Movies: $movies")
        })

        moviesViewModel.discoverMovies(1)

        enableEdgeToEdge()
        setContent {
            MyMoviesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun AppSearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
    )
}

@Preview
@Composable
fun SmallMovieItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.sample_image
            ),
            contentDescription = null,
            modifier = modifier
        )
    }
}



@Preview
@Composable
fun TelaHome() {
    MyMoviesAppTheme {
        AppSearchBar()
    }
}