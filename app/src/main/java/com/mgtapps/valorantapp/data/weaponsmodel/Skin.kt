package com.mgtapps.valorantapp.data.weaponsmodel

import com.google.gson.annotations.SerializedName

data class Skin(
    @SerializedName("uuid") var uuid : String,
    @SerializedName("displayName") var displayName : String,
    @SerializedName("displayIcon") var displayIcon : String,
)