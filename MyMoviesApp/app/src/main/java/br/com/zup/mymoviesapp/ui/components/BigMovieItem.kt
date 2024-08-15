package br.com.zup.mymoviesapp.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.zup.mymoviesapp.R
import br.com.zup.mymoviesapp.ui.theme.MyMoviesAppTheme


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BigMovieItemReview() {
    MyMoviesAppTheme {
        BigMovieItem(
            R.drawable.sample_image,
            R.string.movie_title_sample,
            R.string.movie_synopsis_sample,
            R.string.movie_release_date_sample,
            R.string.movie_reviews_sample,
            Modifier.padding(8.dp)
        )
    }
}

@Composable
fun BigMovieItem(
    @DrawableRes drawable: Int,
    @StringRes title: Int,
    @StringRes description: Int,
    @StringRes releaseDate: Int,
    @StringRes reviews: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .width(255.dp)
                .height(200.dp),

            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(
                    id = drawable
                ),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.size(80.dp, 200.dp)
            )
            Column(
                Modifier.fillMaxHeight(1.0f)
            ) {
                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    overflow = TextOverflow.Ellipsis
                )
                Row {
                    Text(
                        text = stringResource(id = reviews),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Text(
                        text = stringResource(id = releaseDate),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                Text(
                    text = stringResource(id = description),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    overflow = TextOverflow.Ellipsis
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
            )

        }
    }
}