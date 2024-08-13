package br.com.zup.mymoviesapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.zup.mymoviesapp.MovieSample
import br.com.zup.mymoviesapp.R
import br.com.zup.mymoviesapp.ui.theme.MyMoviesAppTheme

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BigMovieItemGridPreview() {
    MyMoviesAppTheme {
        BigMovieItemGrid()
    }
}

@Composable
fun BigMovieItemGrid(
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Fixed(1),
        modifier = modifier
    ) {
        items(bigMovies) { movie ->
            BigMovieItem(
                drawable = movie.drawable,
                title = movie.title,
                description = movie.description,
                releaseDate = movie.releaseDate,
                reviews = movie.reviews
            )
        }
    }
}

val bigMovies = listOf(
    MovieSample(
        drawable = R.drawable.sample_image,
        title = R.string.movie_title_sample,
        description = R.string.movie_synopsis_sample,
        releaseDate = R.string.movie_release_date_sample,
        reviews = R.string.movie_reviews_sample
    ),
    MovieSample(
        drawable = R.drawable.sample_image,
        title = R.string.movie_title_sample,
        description = R.string.movie_synopsis_sample,
        releaseDate = R.string.movie_release_date_sample,
        reviews = R.string.movie_reviews_sample
    ),
    MovieSample(
        drawable = R.drawable.sample_image,
        title = R.string.movie_title_sample,
        description = R.string.movie_synopsis_sample,
        releaseDate = R.string.movie_release_date_sample,
        reviews = R.string.movie_reviews_sample
    )
)