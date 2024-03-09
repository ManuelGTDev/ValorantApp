package com.mgtapps.valorantapp.data.remote

import com.mgtapps.valorantapp.domain.models.agent_model.Agent
import com.mgtapps.valorantapp.domain.models.weapon_model.Weapon
import retrofit2.Response
import retrofit2.http.GET

interface ValorantApi {

    @GET("/v1/agents")
    suspend fun getAllAgents():Response<Agent>

    @GET("/v1/weapons")
    suspend fun getAllWeapons():Response<Weapon>
}