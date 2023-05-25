package com.mgtapps.valorantapp.data.repository

import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.data.model.provider.ValorantProvider
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon
import com.mgtapps.valorantapp.network.ValorantService


class ValorantRepository {

    //Clase encargada de ver si accedemos a la parte de Network, Database...
    private val api = ValorantService()

    suspend fun getAllAgents(): Agent {
        //Recuperamos los agentes
        val response: Agent = api.getAgents()

        //Rellenamos la lista de Agentes (no es necesario, pero es para tenerlos todos en local
        // y no tener que hacer muchas llamadas a la API)
        ValorantProvider.agents = response

        return response
    }


    suspend fun getAllWeapons(): Weapon {
        val response: Weapon = api.getWeapons()
        ValorantProvider.weapons = response

        return response
    }

}