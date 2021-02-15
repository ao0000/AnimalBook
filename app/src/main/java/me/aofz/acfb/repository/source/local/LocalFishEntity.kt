package me.aofz.acfb.repository.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fish_table")
data class LocalFishEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "fish_id")
    val id: Int,
    @ColumnInfo(name = "fish_image_url")
    val image_url: String
)