package me.aofz.acfb.model

import com.squareup.moshi.Json

class BugEntity(
    val id: Int,
    val name: Name,
    val availability: Availability,
    val price: Int,
    @Json(name = "price-flick") val priceFk: Int,
    @Json(name = "image_uri") val imageUri: String,
    @Json(name = "icon_uri") val iconUri: String
) {
    fun toModel(): Bug = Bug(id, name.nameJPja, price, imageUri, iconUri)
}