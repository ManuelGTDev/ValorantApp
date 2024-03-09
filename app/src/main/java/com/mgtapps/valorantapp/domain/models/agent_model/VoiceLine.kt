package com.mgtapps.valorantapp.domain.models.agent_model

data class VoiceLine(
    val maxDuration: Double,
    val mediaList: List<Media>,
    val minDuration: Double
)