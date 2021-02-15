package me.aofz.acfb.repository.source.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FishDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFish(fishList: List<LocalFishEntity>)

    @Query("SELECT * FROM fish_table ORDER BY fish_id ASC")
    suspend fun getAllFishList(): LiveData<List<LocalFishEntity>>

    @Delete
    suspend fun deleteFish(fish: LocalFishEntity)

}
