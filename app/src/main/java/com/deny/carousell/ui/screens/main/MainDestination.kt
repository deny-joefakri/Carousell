package com.deny.carousell.ui.screens.main

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.deny.carousell.ui.base.BaseDestination
import com.deny.carousell.ui.models.UiNewsModel

const val KeyId = "id"
const val KeyModel = "model"

sealed class MainDestination {

    object Home : BaseDestination("home")

}
