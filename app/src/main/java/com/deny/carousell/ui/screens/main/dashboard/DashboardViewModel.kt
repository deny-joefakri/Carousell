package com.deny.carousell.ui.screens.main.dashboard

import androidx.lifecycle.viewModelScope
import com.deny.carousell.ui.base.BaseViewModel
import com.deny.carousell.ui.models.UiNewsModel
import com.deny.carousell.ui.models.toUiNewsModel
import com.deny.carousell.util.DispatchersProvider
import com.deny.carouselldomain.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getNewsUseCase: GetNewsUseCase,
    private val dispatchersProvider: DispatchersProvider,
) : BaseViewModel() {

    private val _uiModels = MutableStateFlow<List<UiNewsModel>>(emptyList())
    val uiModels = _uiModels.asStateFlow()

    init {
        getNewsUseCase()
            .injectLoading()
            .onEach { result ->
                val uiModels = result.map { it.toUiNewsModel() }
                _uiModels.emit(uiModels)
            }
            .flowOn(dispatchersProvider.io)
            .catch { e -> _error.emit(e) }
            .launchIn(viewModelScope)

    }

}
