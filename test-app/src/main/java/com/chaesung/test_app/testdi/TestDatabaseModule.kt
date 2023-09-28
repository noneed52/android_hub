package com.chaesung.test_app.testdi

import com.chaesung.data.HubModelRepository
import com.chaesung.data.di.DataModule
import com.chaesung.data.di.FakeHubModelRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
interface FakeDataModule {

    @Binds
    abstract fun bindRepository(
        fakeRepository: FakeHubModelRepository
    ): HubModelRepository
}