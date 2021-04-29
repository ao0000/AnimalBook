package me.aofz.acfb.model

import com.squareup.moshi.Json

data class SeaCreatureEntity(
    val id: Int,
    val name: Name,
    val availability: Availability,
    val shadow: String,
    val price: Int,
    @Json(name = "image_uri") val imageUri: String,
    @Json(name = "icon_uri") val iconUri: String
) {
    fun toModel(): SeaCreature = SeaCreature(id, name.nameJPja, price, imageUri, iconUri)
}