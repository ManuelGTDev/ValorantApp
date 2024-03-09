package com.mgtapps.valorantapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mgtapps.valorantapp.domain.models.weapon_model.Weapon
import com.mgtapps.valorantapp.domain.use_cases.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponViewModel @Inject constructor(
    private val getWeaponUseCase: GetWeaponsUseCase
): ViewModel() {
    val weaponModel = MutableLiveData<Weapon>()

    fun onCreate(){
        viewModelScope.launch {
            val result: Weapon? = getWeaponUseCase()

            if(result != null){
                weaponModel.postValue(result!!)
            }
        }
    }

}