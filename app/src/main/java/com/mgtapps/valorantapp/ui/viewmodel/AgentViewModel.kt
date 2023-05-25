package com.mgtapps.valorantapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.domain.GetAgentsUseCase
import com.mgtapps.valorantapp.domain.GetAllAgentsValorant
import kotlinx.coroutines.launch

class AgentViewModel : ViewModel(){

    val agentModel = MutableLiveData<Agent>()

    var getAgentsUseCase = GetAgentsUseCase()

    var getAllAgentsValo = GetAllAgentsValorant()

    fun onCreate(){

        //Nos permite crear una corrutina que se controla automaticamente
        viewModelScope.launch {

            val result: Agent? = getAgentsUseCase()

            if(result != null){

                agentModel.postValue(result!!)
            }
        }
    }

    fun getAllAgents(){

        val agent: Agent? = getAllAgentsValo()
        if (agent!=null){
            agentModel.postValue(agent!!)
        }

    }

}