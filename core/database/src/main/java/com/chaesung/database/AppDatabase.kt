package com.chaesung.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HubModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun myModelDao(): HubModelDao
}
