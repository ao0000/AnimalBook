package me.aofz.acfb.repository.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.aofz.acfb.model.Fish

@Entity(tableName = "fish_table")
data class LocalFishEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "fish_id")
    val id: Int,

    @ColumnInfo(name = "fish_name")
    val name: String,

    @ColumnInfo(name = "fish_price")
    val price: Int,

    @ColumnInfo(name = "fish_icon_uri")
    val iconUri: String,

    @ColumnInfo(name = "fish_image_url")
    val imageUri: String

) {
    fun toFish() = Fish(id, name, price, iconUri, imageUri)
}
