package com.mgtapps.valorantapp.domain

import com.mgtapps.valorantapp.data.model.provider.ValorantProvider
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon


class GetAllWeaponsValorant {
    operator fun invoke(): Weapon?{
        val weapons: Weapon = ValorantProvider.weapons

        if (weapons != null){
            return weapons
        }
        return null
    }
}