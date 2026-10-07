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
    val description_raw: String?,       // hanya tersedia di endpoint /games/{id}
    val metacritic: Int?,               // skor Metacritic (nullable — tidak semua game punya)
    val genres: List<Genre>?,           // daftar genre game
    val platforms: List<PlatformWrapper>? // daftar platform yang tersedia
)

data class Genre(
    val id: Int,
    val name: String
)

data class PlatformWrapper(
    val platform: PlatformDetail
)

data class PlatformDetail(
    val id: Int,
    val name: String,
    val slug: String
)
