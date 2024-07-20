package com.deny.carousell.ui.screens.main.dashboard

import android.Manifest.permission.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.deny.carousell.R
import com.deny.carousell.extensions.collectAsEffect
import com.deny.carousell.extensions.showToast
import com.deny.carousell.lib.IsLoading
import com.deny.carousell.ui.base.BaseDestination
import com.deny.carousell.ui.base.BaseScreen
import com.deny.carousell.ui.common.AppBar
import com.deny.carousell.ui.models.UiNewsModel
import com.deny.carousell.ui.showToast
import com.deny.carousell.ui.theme.ComposeTheme

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    navigator: (destination: BaseDestination) -> Unit,
    isResultOk: Boolean = false,
) = BaseScreen(
    isDarkStatusBarIcons = false,
) {
    val context = LocalContext.current
    viewModel.error.collectAsEffect { e -> e.showToast(context) }
    viewModel.navigator.collectAsEffect { destination -> navigator(destination) }

    val isLoading: IsLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val uiModels: List<UiNewsModel> by viewModel.uiModels.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        if (isResultOk) {
            context.showToast(context.getString(R.string.message_updated))
        }
    }

    HomeScreenContent(
        uiModels = uiModels,
        isLoading = isLoading,
        onItemClick = {  },
        onItemLongClick = {  }
    )
}

@Composable
private fun HomeScreenContent(
    uiModels: List<UiNewsModel>,
    isLoading: IsLoading,
    onItemClick: (UiNewsModel) -> Unit,
    onItemLongClick: (UiNewsModel) -> Unit,
) {
    Scaffold(topBar = {
        AppBar(R.string.home_title_bar,
            onRecentClick = {


            }, onPopularClick = {


            }
        )
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                ItemList(
                    uiModels = uiModels,
                    onItemClick = onItemClick,
                    onItemLongClick = onItemLongClick
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    ComposeTheme {
        HomeScreenContent(
            uiModels = listOf(
                UiNewsModel("1", "name1", "description1", "url1",0,0),
                UiNewsModel("2", "name2", "description2", "url2", 0,0),
                UiNewsModel("3", "name3", "description3", "url3", 0,0,)),
            isLoading = false,
            onItemClick = {},
            onItemLongClick = {}
        )
    }
}
