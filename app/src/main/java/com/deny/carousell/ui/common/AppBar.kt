package com.deny.carousell.ui.common

import androidx.annotation.StringRes
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.deny.carousell.R
import com.deny.carousell.ui.theme.AppTheme.colors
import com.deny.carousell.ui.theme.ComposeTheme

@Composable
fun AppBar(
    @StringRes title: Int,
    onRecentClick: () -> Unit,
    onPopularClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        modifier = modifier,
        title = { Text(
            text = stringResource(title),
            color = Color.White
        ) },
        backgroundColor = colors.topAppBarBackground, // Replace with your desired color
        actions = {
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu),
                    tint = Color.White
                )
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(onClick = {
                    onRecentClick()
                    showMenu = false
                }) {
                    Text(stringResource(R.string.menu_recent))
                }
                DropdownMenuItem(onClick = {
                    onPopularClick()
                    showMenu = false
                }) {
                    Text(stringResource(R.string.menu_popular))
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun AppBarPreview() {
    ComposeTheme { AppBar(R.string.app_name, {}, {}) }
}
