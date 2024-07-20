package com.deny.carousell.ui.screens.main.dashboard

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deny.carousell.ui.models.UiNewsModel
import com.deny.carousell.ui.theme.ComposeTheme

@Composable
fun ItemList(
    uiModels: List<UiNewsModel>,
    onItemClick: (UiNewsModel) -> Unit,
    onItemLongClick: (UiNewsModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(uiModels) { uiNewsModel ->
            Item(
                uiModel = uiNewsModel,
                onClick = onItemClick,
                onLongClick = onItemLongClick
            )
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemListPreview() {
    ComposeTheme {
        ItemList(
            uiModels = listOf(
                UiNewsModel("1", "name1", "description1", "url1",0,0),
                UiNewsModel("2", "name2", "description2", "url2", 0,0),
                UiNewsModel("3", "name3", "description3", "url3", 0,0,)),
            onItemClick = {},
            onItemLongClick = {}
        )
    }
}
