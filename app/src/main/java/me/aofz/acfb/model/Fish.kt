package me.aofz.acfb.model

data class Fish(
    override val id: Int,
    override val name: String,
    val price: Int,
    val imageUri: String,
    override val iconUri: String
) : Animal