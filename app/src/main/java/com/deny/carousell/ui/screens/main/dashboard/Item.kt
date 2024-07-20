package com.deny.carousell.ui.screens.main.dashboard

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.deny.carousell.R
import com.deny.carousell.ui.models.UiNewsModel
import com.deny.carousell.ui.theme.AppTheme.dimensions
import com.deny.carousell.ui.theme.ComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Item(
    uiModel: UiNewsModel,
    onClick: (UiNewsModel) -> Unit,
    onLongClick: (UiNewsModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { onClick(uiModel) },
                onLongClick = { expanded = true }
            )
    ) {
        Row {
            Text(
                modifier = Modifier
                    .padding(dimensions.spacingMedium)
                    .weight(1f),
                text = uiModel.id
            )
            Text(
                modifier = Modifier
                    .padding(dimensions.spacingMedium)
                    .weight(2f),
                text = uiModel.title
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(onClick = { onLongClick(uiModel) }) {
                Text(stringResource(id = R.string.third_edit_menu_title))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPreview() {
    ComposeTheme {
        Item(
            uiModel = UiNewsModel("1", "name1", "description1", "url1", 0, 0),
            onClick = {},
            onLongClick = {}
        )
    }
}
