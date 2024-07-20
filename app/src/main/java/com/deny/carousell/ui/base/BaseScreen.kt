package com.deny.carousell.ui.base

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.deny.carousell.R
import com.deny.carousell.util.setStatusBarColor

@Composable
fun BaseScreen(
    isDarkStatusBarIcons: Boolean? = null,
    content: @Composable () -> Unit,
) {
    if (isDarkStatusBarIcons != null) {
        setStatusBarColor(
            color = colorResource(id = R.color.statusBarColor),
            darkIcons = isDarkStatusBarIcons,
        )
    }

    content()
}
