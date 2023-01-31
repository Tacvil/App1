package com.example.myapplication.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.AuthorizationFragment
import com.example.myapplication.HomeFragment
import com.example.myapplication.RegistrationFragment

@Database (entities = [EntityClass::class], version = 1)
abstract class MainDb: RoomDatabase() {
    abstract fun getDao(): Dao

    companion object{
        fun getDb(context: RegistrationFragment): MainDb {
            return Room.databaseBuilder(
                context.requireContext(),
                MainDb::class.java,
                "testDb.db"
            ).build()
        }
        fun getDb(context: HomeFragment): MainDb {
            return Room.databaseBuilder(
                context.requireContext(),
                MainDb::class.java,
                "testDb.db"
            ).build()
        }
        fun getDb(context: AuthorizationFragment): MainDb {
            return Room.databaseBuilder(
                context.requireContext(),
                MainDb::class.java,
                "testDb.db"
            ).build()
        }
    }
}