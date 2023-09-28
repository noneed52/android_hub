package com.chaesung.data

import com.chaesung.database.HubModel
import com.chaesung.database.HubModelDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface HubModelRepository {
    val hubModels: Flow<List<String>>

    suspend fun add(name: String)
}

class DefaultHubModelRepository @Inject constructor(
    private val myModelDao: HubModelDao
) : HubModelRepository {

    override val hubModels: Flow<List<String>> =
        myModelDao.getMyModels().map { items -> items.map { it.name } }

    override suspend fun add(name: String) {
        myModelDao.insertMyModel(HubModel(name = name))
    }
}