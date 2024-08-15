package br.com.zup.mymoviesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.zup.mymoviesapp.ui.components.AppSearchBar
import br.com.zup.mymoviesapp.ui.components.BigMovieItemGrid
import br.com.zup.mymoviesapp.ui.components.HomeSection
import br.com.zup.mymoviesapp.ui.components.SmallMovieItemGrid
import br.com.zup.mymoviesapp.ui.theme.MyMoviesAppTheme
import br.com.zup.mymoviesapp.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val moviesViewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moviesViewModel.movies.observe(this) { movies ->
            Log.d("MainActivity", "Movies: $movies")
        }

        moviesViewModel.discoverMovies(1)

        enableEdgeToEdge()
        setContent {
            MyMoviesAppTheme {
                HomeScreen()
            }
        }
    }
}

data class MovieSample(
    @DrawableRes val drawable: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val releaseDate: Int,
    @StringRes val reviews: Int
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun ScreenContentPreview() {
    MyMoviesAppTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        AppSearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.recently_viewed_section_name) {
            SmallMovieItemGrid()
        }
        HomeSection(title = R.string.discover_section_name) {
            BigMovieItemGrid(Modifier.height(500.dp))
        }
    }
}