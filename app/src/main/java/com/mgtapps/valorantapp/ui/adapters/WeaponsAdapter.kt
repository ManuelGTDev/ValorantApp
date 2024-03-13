package com.mgtapps.valorantapp.ui.adapters

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgtapps.valorantapp.R
import com.mgtapps.valorantapp.domain.models.weapon_model.Data
import com.mgtapps.valorantapp.databinding.RecyclerWeaponsItemBinding
import com.mgtapps.valorantapp.ui.view.WeaponDetailActivity
import com.squareup.picasso.Picasso

class WeaponsAdapter(private val weapons:List<Data>, val onClick: (Data) -> Unit): RecyclerView.Adapter<WeaponsAdapter.WeaponsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return WeaponsViewHolder(layoutInflater.inflate(R.layout.recycler_weapons_item,parent,false), onClick = {
            onClick(it)
        })
    }

    override fun onBindViewHolder(holder: WeaponsViewHolder, position: Int) {
        val item: Data = weapons[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return weapons.size
    }

    inner class WeaponsViewHolder(itemView: View, val onClick: (Data) -> Unit): RecyclerView.ViewHolder(itemView){
        private val binding = RecyclerWeaponsItemBinding.bind(itemView)
        fun bind(weapon: Data){
            binding.weaponName.text = weapon.displayName
            Picasso.get().load(weapon.displayIcon).fit().into(binding.weaponImage)

            //Click en un arma para mostrar su info
            binding.weaponImage.setOnClickListener(View.OnClickListener {
                onClick(weapon)
            })
        }
    }

}