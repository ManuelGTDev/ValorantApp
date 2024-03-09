package com.mgtapps.valorantapp

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mgtapps.valorantapp.databinding.ActivityMainBinding
import com.mgtapps.valorantapp.ui.view.AgentesActivity
import com.mgtapps.valorantapp.ui.view.WeaponsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click en Agentes
        binding.agentsCardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AgentesActivity::class.java)
            //intent.putExtra("personaje", personaje)
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        })

        //Click en Armas
        binding.weaponsCardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, WeaponsActivity::class.java)
            //intent.putExtra("personaje", personaje)
            startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
        })

    }
}