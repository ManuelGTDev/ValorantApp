package com.mgtapps.valorantapp.network

import com.mgtapps.valorantapp.core.RetrofitHelper
import com.mgtapps.valorantapp.data.model.agentsmodel.Agent
import com.mgtapps.valorantapp.data.weaponsmodel.Weapon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ValorantService {

    //Desde aquí indicamos de dónde va a coger lso datos la aplicación, si de una API od e una BD
    //En este caso una API

    private val retrofit = RetrofitHelper.getRetrofit()

    //Obtenemos la lista con todos los agentes, como puede
    // que sea null, le decimos que si es null la ponga en blanco con el operador ?
    suspend fun getAgents(): Agent {

        //Ejecutamos la llamada en un hilo secundario, para no saturar la interfaz del usuario (hilo principal)
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ValorantApiClient::class.java).getAllAgents()
            response.body()?: Agent(listOf(),200)
        }
    }

    suspend fun getWeapons(): Weapon {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ValorantApiClient::class.java).getAllWeapons()
            response.body()?: Weapon(listOf(),200)
        }

    }



}