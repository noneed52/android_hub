package com.chaesung.hub

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chaesung.data.HubModelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HubModelViewModel @Inject constructor(
    private val hubModelRepository: HubModelRepository
) : ViewModel() {

    val uiState: StateFlow<HubModelUiState> = hubModelRepository
        .hubModels.map<List<String>, HubModelUiState> { HubModelUiState.Success(data = it) }
        .catch { emit(HubModelUiState.Error(it)) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HubModelUiState.Loading)

    fun addMyModel(name: String) {
        viewModelScope.launch {
            hubModelRepository.add(name)
        }
    }
}

sealed interface HubModelUiState {
    data object Loading : HubModelUiState
    data class Error(val throwable: Throwable) : HubModelUiState
    data class Success(val data: List<String>) : HubModelUiState
}