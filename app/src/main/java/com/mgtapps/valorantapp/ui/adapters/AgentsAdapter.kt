package com.mgtapps.valorantapp.ui.adapters

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgtapps.valorantapp.R
import com.mgtapps.valorantapp.domain.models.agent_model.Data
import com.mgtapps.valorantapp.databinding.RecyclerAgentsItemBinding
import com.mgtapps.valorantapp.ui.view.AgentDetailActivity

import com.squareup.picasso.Picasso

class AgentsAdapter(private val agents:List<Data>): RecyclerView.Adapter<AgentsAdapter.AgentsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return AgentsViewHolder(layoutInflater.inflate(R.layout.recycler_agents_item,parent,false))
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        val item: Data = agents[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return agents.size
    }


    inner class AgentsViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        private val binding = RecyclerAgentsItemBinding.bind(itemView)

        fun bind(agent: Data){
            binding.agentName.text = agent.displayName
            Picasso.get().load(agent.fullPortraitV2).fit().into(binding.agentImage)




            //Click en un agente para mostrar su info
            binding.agentImage.setOnClickListener(View.OnClickListener {

                val intent = Intent(itemView.context, AgentDetailActivity::class.java)
                intent.putExtra("agentName", agent.displayName)
                intent.putExtra("agentImage", agent.fullPortraitV2)
                intent.putExtra("agentDescription",agent.description)
                itemView.context.startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(itemView.context as Activity?
                ).toBundle())


            })


        }

    }



}