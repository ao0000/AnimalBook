package me.aofz.acfb.model

import com.squareup.moshi.Json


data class Availability(
    @Json(name = "month-northern") val monthNorthern: String,
    @Json(name = "month-southern") val monthSouthern: String,
    val time: String,
    val isAllDay: Boolean,
    val isAllYear: Boolean,
    @Json(name = "month-array-northern") val monthArrayNorthern: List<String>,
    @Json(name = "month-array-southern") val monthArraySouthern: List<String>,
    @Json(name = "time-array") val timeArray: List<String>
)