package com.darkishlol.biobuddy.domain.model

data class Pet(
    override val id: String,
    override val name: String,
    override val photoUri: String? = null,
    val breed: String,
    val species: String // "Dog", "Cat", etc.
) : Careable
