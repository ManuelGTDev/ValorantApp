package com.mgtapps.valorantapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgtapps.valorantapp.domain.models.agent_model.Agent
import com.mgtapps.valorantapp.domain.use_cases.GetAgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val getAgentsUseCase: GetAgentsUseCase
): ViewModel(){
    val agentModel = MutableLiveData<Agent>()

    fun onCreate(){

        viewModelScope.launch {

            val result: Agent? = getAgentsUseCase()

            if(result != null){

                agentModel.postValue(result!!)
            }
        }
    }

}