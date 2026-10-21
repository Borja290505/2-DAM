package com.example.superheroes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SuperHeroe(
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val power: Float
): Parcelable{

}