package com.example.myapplication.room

import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Insert
    fun insertItem(item: EntityClass)
    @Query("SELECT * FROM entityItems")
    fun getAllItem(): Flow<List<EntityClass>>
}