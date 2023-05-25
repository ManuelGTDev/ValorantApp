package com.mgtapps.valorantapp.network

import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon
import retrofit2.Response
import retrofit2.http.GET

interface ValorantApiClient {

    @GET("/v1/agents")
    suspend fun getAllAgents():Response<Agent>

    @GET("/v1/weapons")
    suspend fun getAllWeapons():Response<Weapon>
}