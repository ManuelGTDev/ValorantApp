package com.mgtapps.valorantapp.domain

import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.data.repository.ValorantRepository


class GetAgentsUseCase {

    private val repository = ValorantRepository()
    suspend operator fun invoke(): Agent? = repository.getAllAgents()
}