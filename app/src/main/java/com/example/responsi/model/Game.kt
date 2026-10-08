package com.example.responsi.model

import com.google.gson.annotations.SerializedName

// struktur pembungkus respons list dari endpoint /games
data class GameResponse(
    val results: List<Game>
)

// representasi satu game dari RAWG API
data class Game(
    val id: Int,
    val name: String,
    val rating: Double,
    val released: String?,

    @SerializedName("background_image") val backgroundImage: String?,
    val description_raw: String?,
    val metacritic: Int?,
    val genres: List<Genre>?,
    val platforms: List<PlatformWrapper>?
)

// Data class pendukung field genres
data class Genre(
    val id: Int,
    val name: String
)

// Data class pembungkus platform — API
data class PlatformWrapper(
    val platform: PlatformDetail
)

data class PlatformDetail(
    val id: Int,
    val name: String,
    val slug: String
)
