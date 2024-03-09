package com.mgtapps.valorantapp.ui.view

import android.R
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mgtapps.valorantapp.domain.models.agent_model.Data
import com.mgtapps.valorantapp.databinding.ActivityAgentesBinding
import com.mgtapps.valorantapp.ui.adapters.AgentsAdapter
import com.mgtapps.valorantapp.ui.viewmodel.AgentsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgentesBinding

    private val agentsViewModel: AgentsViewModel by viewModels()

    private lateinit var adapter: AgentsAdapter
    private var agents = mutableListOf<Data>()

    private var linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgentesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        agentsViewModel.onCreate()

        //Todoo lo de aquí dentro, va enganchado al live data
        agentsViewModel.agentModel.observe(this, Observer {

            agents = it.data as MutableList<Data>

            initRecyclerView()
        })

        //Click para el siguiente agente
        binding.buttonAgentsNext.setOnClickListener(View.OnClickListener {
            binding.recyclerAgents.animation = AnimationUtils.loadAnimation(this,R.anim.fade_in)

            if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < adapter.itemCount -1 ){
                linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1);

            }
        })

        //Click para el siguiente agente
        binding.buttonAgentsPrev.setOnClickListener(View.OnClickListener {
            binding.recyclerAgents.animation = AnimationUtils.loadAnimation(this,R.anim.fade_in)


            if (linearLayoutManager.findLastCompletelyVisibleItemPosition() < adapter.itemCount -1 ){
                linearLayoutManager.scrollToPosition(linearLayoutManager.findLastCompletelyVisibleItemPosition() - 1);
            }
        })

        initRecyclerView()

    }




    private fun initRecyclerView(){
        adapter = AgentsAdapter(agents)
        binding.recyclerAgents.layoutManager = linearLayoutManager
        binding.recyclerAgents.adapter = adapter
    }
}