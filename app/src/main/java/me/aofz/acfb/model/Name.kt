package me.aofz.acfb.model

import com.squareup.moshi.Json

data class Name(
    @Json(name = "name-USen") val nameUSen: String,
    @Json(name = "name-JPja") val nameJPja: String
)