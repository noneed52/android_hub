package com.chaesung.data

import com.chaesung.database.HubModel
import com.chaesung.database.HubModelDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultHubModelRepositoryTest {

    @Test
    fun hubModels_newItemSaved_itemIsReturned() = runTest {
        val repository = DefaultHubModelRepository(FakeHubModelDao())

        repository.add("Repository")

        assertEquals(repository.hubModels.first().size, 1)
    }

}

private class FakeHubModelDao : HubModelDao {

    private val data = mutableListOf<HubModel>()

    override fun getMyModels(): Flow<List<HubModel>> = flow {
        emit(data)
    }

    override suspend fun insertMyModel(item: HubModel) {
        data.add(0, item)
    }
}