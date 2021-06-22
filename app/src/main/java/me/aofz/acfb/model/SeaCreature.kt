package me.aofz.acfb.model

data class SeaCreature(
    override val id: Int,
    override val name: String,
    override val price: Int,
    override val imageUri: String,
    override val iconUri: String
) : Animal