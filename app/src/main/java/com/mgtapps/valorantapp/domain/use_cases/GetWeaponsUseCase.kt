package com.mgtapps.valorantapp.domain.use_cases

import com.mgtapps.valorantapp.data.repository.ValorantValorantRepositoryImpl
import com.mgtapps.valorantapp.domain.ValorantRepository
import com.mgtapps.valorantapp.domain.models.weapon_model.Weapon
import javax.inject.Inject


class GetWeaponsUseCase @Inject constructor(
    private val repository: ValorantRepository
) {
    suspend operator fun invoke(): Weapon? = repository.getWeapons()
}