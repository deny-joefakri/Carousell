package com.deny.carousell.ui.screens.dashboard

import app.cash.turbine.test
import com.deny.carousell.test.CoroutineTestRule
import com.deny.carousell.test.MockUtil
import com.deny.carousell.ui.models.toUiNewsModel
import com.deny.carousell.ui.screens.main.dashboard.DashboardViewModel
import com.deny.carousell.util.DispatchersProvider
import com.deny.carouselldomain.domain.models.NewsModel
import com.deny.carouselldomain.domain.usecases.GetNewsUseCase
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class DashboardViewModelTest {

    @get:Rule
    val coroutinesRule = CoroutineTestRule()

    private val mockGetNewsUseCase: GetNewsUseCase = mockk()

    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setUp() {
        every { mockGetNewsUseCase() } returns flowOf(MockUtil.models)

        viewModel = DashboardViewModel(
            getNewsUseCase = mockGetNewsUseCase,
            dispatchersProvider = coroutinesRule.testDispatcherProvider
        )
    }

    @Test
    fun `When loading models successfully, it shows the model list`() = runTest {
        viewModel.uiModels.test {
            expectMostRecentItem() shouldBe MockUtil.models.map { it.toUiNewsModel() }
        }
    }

    @Test
    fun `When loading models failed, it shows the corresponding error`() = runTest {
        val error = Exception()
        every { mockGetNewsUseCase() } returns flow { throw error }
        initViewModel(dispatchers = CoroutineTestRule(StandardTestDispatcher()).testDispatcherProvider)

        viewModel.error.test {
            advanceUntilIdle()

            expectMostRecentItem() shouldBe error
        }

    }

    @Test
    fun `When sorting models by recent, it sorts correctly`() = runTest {
        viewModel.sortByRecent()

        viewModel.sortedUiModels.test {
            expectMostRecentItem() shouldBe MockUtil.models
                .sortedByDescending { it.timeCreated }
                .map { it.toUiNewsModel() }
        }
    }

    @Test
    fun `When sorting models by popular, it sorts correctly`() = runTest {
        viewModel.sortByPopular()

        viewModel.sortedUiModels.test {
            expectMostRecentItem() shouldBe MockUtil.models
                .sortedWith(compareByDescending<NewsModel> { it.rank }
                    .thenByDescending { it.timeCreated })
                .map { it.toUiNewsModel() }
        }
    }

    private fun initViewModel(dispatchers: DispatchersProvider = coroutinesRule.testDispatcherProvider) {
        viewModel = DashboardViewModel(
            mockGetNewsUseCase,
            dispatchers
        )
    }
}
