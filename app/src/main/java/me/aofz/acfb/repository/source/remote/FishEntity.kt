package me.aofz.acfb.repository.source.remote

import com.squareup.moshi.Json
import me.aofz.acfb.model.Fish

data class FishEntity(
    val id: Int,
    @Json(name = "file-name") val fileName: String,
    val name: Name,
    val availability: Availability,
    val shadow: String,
    val price: Long,
    @Json(name = "price-cj") val priceCj: Long,
    @Json(name = "catch-phrase") val catchPhrase: String,
    @Json(name = "museum-phrase") val museumPhrase: String,
    @Json(name = "alt-catch-phrase") val altCatchPhrase: List<String>,
    @Json(name = "image_uri") val imageUri: String,
    @Json(name = "icon_uri") val iconUri: String
) {
    fun toFish() = Fish(id, name.nameJPja, price, imageUri, iconUri)
}

data class Name(
    @Json(name = "name-USen") val nameUSen: String,
    @Json(name = "name-CNzh") val nameCNzh: String,
    @Json(name = "name-EUde") val nameEUde: String,
    @Json(name = "name-EUes") val nameEUes: String,
    @Json(name = "name-EUfr") val nameEUfr: String,
    @Json(name = "name-EUit") val nameEUit: String,
    @Json(name = "name-JPja") val nameJPja: String,
    @Json(name = "name-KRko") val nameKRko: String,
    @Json(name = "name-EUnl") val nameEUnl: String,
    @Json(name = "name-EUru") val nameEUru: String,
    @Json(name = "name-EUen") val nameEUen: String,
    @Json(name = "name-USes") val nameUSes: String,
    @Json(name = "name-USfr") val nameUSfr: String,
    @Json(name = "name-TWzh") val nameTWzh: String
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