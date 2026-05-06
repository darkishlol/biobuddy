package com.darkishlol.biobuddy.domain.model

data class Plant(
    override val id: String,
    override val name: String,
    override val photoUri: String? = null,
    val lightLevel: String,
    val wateringIntervalDays: Int
) : Careable
