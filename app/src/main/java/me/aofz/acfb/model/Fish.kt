package me.aofz.acfb.model

data class Fish(
    override val id: Int,
    override val name: String,
    override val price: Int,
    override val imageUri: String,
    override val iconUri: String
) : Animal