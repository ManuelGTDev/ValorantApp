package com.mgtapps.valorantapp.domain.use_cases

import com.mgtapps.valorantapp.domain.ValorantRepository
import com.mgtapps.valorantapp.domain.models.agent_model.Agent
import javax.inject.Inject


class GetAgentsUseCase @Inject constructor(
    private val valorantRepository : ValorantRepository
){
    suspend operator fun invoke(): Agent? = valorantRepository.getAgents()
}