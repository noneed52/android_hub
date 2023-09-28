package com.chaesung.data.di

import com.chaesung.data.DefaultHubModelRepository
import com.chaesung.data.HubModelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsHubModelRepository(
        hubModelRepository: DefaultHubModelRepository
    ): HubModelRepository
}

class FakeHubModelRepository @Inject constructor() : HubModelRepository {
    override val hubModels: Flow<List<String>> = flowOf(fakeHubModels)

    override suspend fun add(name: String) {
        throw NotImplementedError()
    }
}

val fakeHubModels = listOf("One", "Two", "Three")