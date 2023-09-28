package com.chaesung.database.di

import android.content.Context
import androidx.room.Room
import com.chaesung.database.AppDatabase
import com.chaesung.database.HubModelDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideMyModelDao(appDatabase: AppDatabase): HubModelDao {
        return appDatabase.myModelDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "HubModel"
        ).build()
    }
}
