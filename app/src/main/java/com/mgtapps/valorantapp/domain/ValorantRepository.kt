package com.mgtapps.valorantapp.domain

import com.mgtapps.valorantapp.domain.models.agent_model.Agent
import com.mgtapps.valorantapp.domain.models.weapon_model.Weapon

interface ValorantRepository {
    suspend fun getAgents(): Agent
    suspend fun getWeapons(): Weapon
}