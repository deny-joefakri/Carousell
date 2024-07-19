package com.deny.carouselldomain.domain.usecases

import com.deny.carouselldomain.domain.repositories.Repository
import com.deny.carouselldomain.domain.test.MockUtil
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetNewsUseCaseTest {

    private lateinit var mockRepository: Repository
    private lateinit var getNewsUseCase: GetNewsUseCase

    @Before
    fun setUp() {
        mockRepository = mockk()
        getNewsUseCase = GetNewsUseCase(mockRepository)
    }

    @Test
    fun `When request successful, it returns success`() = runTest {
        val expected = MockUtil.news
        every { mockRepository.getNews() } returns flowOf(expected)

        getNewsUseCase().collect {
            it shouldBe expected
        }
    }

    @Test
    fun `When request failed, it returns error`() = runTest {
        val expected = Exception()
        every { mockRepository.getNews() } returns flow { throw expected }

        getNewsUseCase().catch {
            it shouldBe expected
        }.collect()
    }
}
