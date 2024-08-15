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
import br.com.zup.mymoviesapp.sample.sampleMovies
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
        items(sampleMovies) { movie ->
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