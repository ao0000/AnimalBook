package me.aofz.acfb.model

data class Bug(
    override val id: Int,
    override val name: String,
    val price: Int,
    val imageUri: String,
    override val iconUri: String
) : Item