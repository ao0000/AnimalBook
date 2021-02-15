package me.aofz.acfb.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Fish(
    val id: Int,
    val name: String,
    val price: Int,
    val iconUri: String,
    val imageUri: String
) : Parcelable