package me.aofz.acfb.repository.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalFishEntity::class], version = 1, exportSchema = true)
abstract class FishDatabase : RoomDatabase() {
    abstract fun fishDatabaseDAO(): FishDatabaseDAO
}