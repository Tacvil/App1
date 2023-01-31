package com.example.myapplication.room

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

@androidx.room.Entity (tableName = "entityItems")
data class EntityClass (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "passWord")
    var passWord: String
        )