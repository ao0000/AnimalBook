package me.aofz.acfb.repository.source.local

import androidx.room.*

@Dao
interface FishDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFishList(fishList: List<LocalFishEntity>)

    @Query("SELECT * FROM fish_table ORDER BY fish_id ASC")
    suspend fun getAllFishList(): List<LocalFishEntity>

    @Delete
    suspend fun deleteFish(fish: LocalFishEntity)

}
