package com.mgtapps.valorantapp.domain

import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.data.model.provider.ValorantProvider


class GetAllAgentsValorant {

    operator fun invoke(): Agent?{
        val agents: Agent = ValorantProvider.agents

        if (agents != null){
            return agents
        }
        return null
    }
}