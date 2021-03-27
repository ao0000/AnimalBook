package me.aofz.acfb.repository.source.remote

import com.squareup.moshi.Json
import me.aofz.acfb.model.Fish


data class FishEntity(
    val id: Int,
    val name: Name,
    val availability: Availability,
    val shadow: String,
    val price: Int,
    @Json(name = "price-cj") val priceCj: Int,
    @Json(name = "icon_uri") val iconUri: String,
    @Json(name = "image_uri") val imageUri: String
) {
    fun toModel() = Fish(id, name.nameJPja, price, iconUri, imageUri)
}

data class Name(
    @Json(name = "name-USen") val nameUSen: String,
    @Json(name = "name-JPja") val nameJPja: String
)

data class Availability(
    @Json(name = "month-northern") val monthNorthern: String,
    @Json(name = "month-southern") val monthSouthern: String,
    val time: String,
    val isAllDay: Boolean,
    val isAllYear: Boolean,
    val location: String,
    val rarity: String,
    @Json(name = "month-array-northern") val monthArrayNorthern: List<String>,
    @Json(name = "month-array-southern") val monthArraySouthern: List<String>,
    @Json(name = "time-array") val timeArray: List<String>
)