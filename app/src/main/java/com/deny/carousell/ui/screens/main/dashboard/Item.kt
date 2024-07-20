package com.deny.carousell.ui.screens.main.dashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.deny.carousell.R
import com.deny.carousell.ui.models.UiNewsModel
import com.deny.carousell.ui.theme.AppTheme.dimensions
import com.deny.carousell.ui.theme.ComposeTheme
import com.deny.carousell.ui.theme.LocalAppDimensions
import com.deny.carousell.util.DateUtil.formatTime

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Item(
    uiModel: UiNewsModel,
    modifier: Modifier = Modifier,
) {

    Card(
        shape = RoundedCornerShape(dimensions.spacingXSmall),
        elevation = dimensions.spacing2XSmall,
        modifier = Modifier
            .padding(horizontal = dimensions.spacingSmall2X, vertical = dimensions.spacingXSmall)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            Image(
                painter = rememberImagePainter(uiModel.bannerUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Column(
                modifier = Modifier
                    .padding(dimensions.spacingMedium)
            ) {
                Text(
                    text = uiModel.title,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(dimensions.spacingXSmall))
                Text(
                    text = uiModel.description,
                    style = MaterialTheme.typography.body2,
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(dimensions.spacingXSmall))
                Text(
                    text = formatTime(LocalContext.current, uiModel.timeCreated),
                    style = MaterialTheme.typography.caption,
                    color = Color.Gray
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ItemPreview() {
    ComposeTheme {
        Item(
            uiModel = UiNewsModel("1", "name1", "description1", "https://storage.googleapis.com/carousell-interview-assets/android/images/carousell-hero-image_10june.png", 1532939458, 0),
        )
    }
}
