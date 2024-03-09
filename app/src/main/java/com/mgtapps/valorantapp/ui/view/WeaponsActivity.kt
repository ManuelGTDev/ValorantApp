package com.mgtapps.valorantapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgtapps.valorantapp.domain.models.weapon_model.Data
import com.mgtapps.valorantapp.databinding.ActivityWeaponsBinding
import com.mgtapps.valorantapp.ui.adapters.WeaponsAdapter
import com.mgtapps.valorantapp.ui.viewmodel.WeaponViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeaponsBinding

    private val weaponsViewModel: WeaponViewModel by viewModels()

    private lateinit var adapter: WeaponsAdapter
    private var weapons = mutableListOf<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeaponsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        weaponsViewModel.onCreate()

        //Todoo lo de aquí dentro, va enganchado al live data
        weaponsViewModel.weaponModel.observe(this, Observer {

            weapons = it.data as MutableList<Data>

            initRecyclerView()
        })

    }


    private fun initRecyclerView(){
        adapter = WeaponsAdapter(weapons)
        binding.recyclerWeapons.layoutManager = LinearLayoutManager(this)
        binding.recyclerWeapons.adapter = adapter
    }

}