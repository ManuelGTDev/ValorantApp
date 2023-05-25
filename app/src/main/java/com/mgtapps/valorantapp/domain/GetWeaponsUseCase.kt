package com.mgtapps.valorantapp.domain

import com.mgtapps.valorantapp.data.repository.ValorantRepository
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon

class GetWeaponsUseCase {

    private val repository = ValorantRepository()
    suspend operator fun invoke(): Weapon? = repository.getAllWeapons()
}