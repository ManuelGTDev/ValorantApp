package com.mgtapps.valorantapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mgtapps.valorantapp.databinding.ActivityWeaponDetailBinding
import com.squareup.picasso.Picasso

class WeaponDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeaponDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeaponDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var weaponName: String? = intent.getStringExtra("weaponName")
        var weaponImage: String? = intent.getStringExtra("weaponImage")
        var weaponCateg: String? = intent.getStringExtra("weaponCateg")

        weaponCateg = weaponCateg!!.substringAfter("::")

        binding.weaponNameDetail.text = weaponName
        binding.weaponType.text = weaponCateg
        binding.weaponNameDetail3.text = weaponName
        binding.weaponNameDetail2.text = weaponName
        Picasso.get().load(weaponImage).fit().into(binding.weaponImageDetail)



    }
}