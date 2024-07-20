package com.deny.carousell.ui.screens.dashboard

import androidx.activity.compose.setContent
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.GrantPermissionRule
import com.deny.carousell.test.MockUtil
import com.deny.carousell.ui.base.BaseDestination
import com.deny.carousell.ui.screens.BaseScreenTest
import com.deny.carousell.ui.screens.MainActivity
import com.deny.carousell.ui.screens.main.dashboard.DashboardScreen
import com.deny.carousell.ui.screens.main.dashboard.DashboardViewModel
import com.deny.carousell.ui.theme.ComposeTheme
import com.deny.carouselldomain.domain.usecases.GetNewsUseCase
import io.kotest.matchers.shouldBe
import io.mockk.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import com.deny.carousell.R
import com.deny.carousell.ui.models.toUiNewsModel
import kotlinx.coroutines.flow.MutableStateFlow

@RunWith(AndroidJUnit4::class)
class DashboardScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val mockViewModel: DashboardViewModel = mockk(relaxed = true)
    private val uiModels = MutableStateFlow(MockUtil.models.map { it.toUiNewsModel() })
    private val isLoading = MutableStateFlow(false)

    @Before
    fun setUp() {
        coEvery { mockViewModel.uiModels } returns uiModels
        coEvery { mockViewModel.isLoading } returns isLoading

        composeTestRule.setContent {
            DashboardScreen(
                viewModel = mockViewModel,
                navigator = { },
                isResultOk = false
            )
        }
    }

}
