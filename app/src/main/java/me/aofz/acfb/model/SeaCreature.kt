package me.aofz.acfb.model

data class SeaCreature(
    override val id: Int,
    override val name: String,
    val price: Int,
    val imageUri: String,
    override val iconUri: String
) : Animal