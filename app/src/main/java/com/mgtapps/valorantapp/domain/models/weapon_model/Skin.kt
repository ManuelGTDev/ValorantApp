package com.mgtapps.valorantapp.domain.models.weapon_model

import com.google.gson.annotations.SerializedName

data class Skin(
    @SerializedName("uuid") var uuid : String,
    @SerializedName("displayName") var displayName : String,
    @SerializedName("displayIcon") var displayIcon : String,
)