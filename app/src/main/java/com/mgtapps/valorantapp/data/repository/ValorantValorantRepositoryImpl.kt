package com.mgtapps.valorantapp.data.repository

import com.mgtapps.valorantapp.data.remote.ValorantApi
import com.mgtapps.valorantapp.domain.ValorantRepository
import com.mgtapps.valorantapp.domain.models.agent_model.Agent
import com.mgtapps.valorantapp.domain.models.weapon_model.Weapon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ValorantValorantRepositoryImpl @Inject constructor(
    private val api: ValorantApi
): ValorantRepository {

    override suspend fun getAgents(): Agent {
        return withContext(Dispatchers.IO) {
            val response = api.getAllAgents()
            response.body() ?: Agent(listOf(), 200)
        }
    }

    override suspend fun getWeapons(): Weapon {
        return withContext(Dispatchers.IO) {
            val response = api.getAllWeapons()
            response.body() ?: Weapon(listOf(), 200)
        }
    }
}