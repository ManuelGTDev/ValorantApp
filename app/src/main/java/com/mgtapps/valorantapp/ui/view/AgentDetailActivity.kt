package com.mgtapps.valorantapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mgtapps.valorantapp.databinding.ActivityAgentDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombreAgente: String? = intent.getStringExtra("agentName")
        var agentImage: String? = intent.getStringExtra("agentImage")
        var agentDescription: String? = intent.getStringExtra("agentDescription")

        binding.agentName3.text = nombreAgente
        binding.agentDescriptionDetail.text = agentDescription
        Picasso.get().load(agentImage).fit().into(binding.agentImageDetail)


    }
}