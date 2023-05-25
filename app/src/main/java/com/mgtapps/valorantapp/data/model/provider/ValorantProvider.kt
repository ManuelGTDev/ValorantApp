package com.mgtapps.valorantapp.data.model.provider

import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon

class ValorantProvider {

    companion object{
        //Por defecto tenemos una lista vacia de agentes, desde AgentRepository
        // llamamos a la API y rellenamos la lista
        var agents: Agent = Agent(listOf(),200)

        //Por defecto tenemos una lista vacia de agentes, desde AgentRepository
        // llamamos a la API y rellenamos la lista
        var weapons: Weapon = Weapon(listOf(),200)
    }
}