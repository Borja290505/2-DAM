package org.iesch.superheroes.model

import android.os.Parcelable

// 1 - Me creo le objeto SuperHeroe y lo hago parcelizable

data class SuperHeroe (

    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val power: Float
)