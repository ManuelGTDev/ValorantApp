package com.mgtapps.valorantapp.domain.models.weapon_model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("uuid") var uuid : String? = null,
    @SerializedName("displayName") var displayName : String? = null,
    @SerializedName("displayIcon") var displayIcon : String? = null,
    @SerializedName("skins") var skins : List<Skin>? = null,
    @SerializedName("category") var category : String? = null


)