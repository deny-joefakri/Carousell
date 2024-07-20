package com.deny.carousell.ui.screens.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.deny.carousell.extensions.getThenRemove
import com.deny.carousell.ui.AppDestination
import com.deny.carousell.ui.base.KeyResultOk
import com.deny.carousell.ui.composable
import com.deny.carousell.ui.navigate
import com.deny.carousell.ui.screens.main.dashboard.DashboardScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
) {
    navigation(
        route = AppDestination.MainNavGraph.route,
        startDestination = MainDestination.Home.destination
    ) {
        composable(destination = MainDestination.Home) { backStackEntry ->
            val isResultOk = backStackEntry.savedStateHandle
                .getThenRemove<Boolean>(KeyResultOk) ?: false
            DashboardScreen(
                navigator = { destination ->
                    navController.navigate(destination, destination.parcelableArgument)
                },
                isResultOk = isResultOk,
            )
        }

        composable(destination = MainDestination.Second) { backStackEntry ->
            /*SecondScreen(
                navigator = { destination -> navController.navigate(destination) },
                id = backStackEntry.arguments?.getString(KeyId).orEmpty()
            )*/
        }

        composable(destination = MainDestination.Third) {
            /*ThirdScreen(
                navigator = { destination -> navController.navigate(destination) },
                model = navController.previousBackStackEntry?.savedStateHandle?.get<UiModel>(
                    KeyModel
                )
            )*/
        }
    }
}
