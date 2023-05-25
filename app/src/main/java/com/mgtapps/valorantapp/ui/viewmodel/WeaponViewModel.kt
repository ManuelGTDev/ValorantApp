package com.mgtapps.valorantapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon
import com.mgtapps.valorantapp.domain.GetAllWeaponsValorant
import com.mgtapps.valorantapp.domain.GetWeaponsUseCase
import kotlinx.coroutines.launch

class WeaponViewModel: ViewModel() {

    val weaponModel = MutableLiveData<Weapon>()

    var getWeaponUseCase = GetWeaponsUseCase()

    var getAllWeaponsValorant = GetAllWeaponsValorant()

    fun onCreate(){

        //Nos permite crear una corrutina que se controla automaticamente
        viewModelScope.launch {

            val result: Weapon? = getWeaponUseCase()

            if(result != null){

                weaponModel.postValue(result!!)
            }
        }
    }

    fun getAllAgents(){

        val agent: Weapon? = getAllWeaponsValorant()
        if (agent!=null){
            weaponModel.postValue(agent!!)
        }

    }

}