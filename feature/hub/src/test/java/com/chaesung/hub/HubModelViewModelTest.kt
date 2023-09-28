package com.chaesung.hub

import com.chaesung.data.HubModelRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class HubModelViewModelTest {
    @Test
    fun uiState_initiallyLoading() = runTest {
        val viewModel = HubModelViewModel(FakeHubModelRepository())
        assertEquals(viewModel.uiState.first(), HubModelUiState.Loading)
    }

    @Test
    fun uiState_onItemSaved_isDisplayed() = runTest {
        val viewModel = HubModelViewModel(FakeHubModelRepository())
        assertEquals(viewModel.uiState.first(), HubModelUiState.Loading)
    }
}

private class FakeHubModelRepository : HubModelRepository {

    private val data = mutableListOf<String>()

    override val hubModels: Flow<List<String>>
        get() = flow { emit(data.toList()) }

    override suspend fun add(name: String) {
        data.add(0, name)
    }
}