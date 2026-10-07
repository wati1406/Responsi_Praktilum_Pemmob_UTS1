package com.example.responsi.model

import com.google.gson.annotations.SerializedName

data class GameResponse(
    val results: List<Game>
)

data class Game(
    val id: Int,
    val name: String,
    val rating: Double,
    val released: String?,
    @SerializedName("background_image") val backgroundImage: String?,
    val description_raw: String? // Note: search api doesn't usually return description_raw, we might need detail api
)
