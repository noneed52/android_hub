package com.chaesung.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity
data class HubModel(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}

@Dao
interface HubModelDao {
    @Query("SELECT * FROM hubmodel ORDER BY uid DESC LIMIT 10")
    fun getMyModels(): Flow<List<HubModel>>

    @Insert
    suspend fun insertMyModel(item: HubModel)
}
