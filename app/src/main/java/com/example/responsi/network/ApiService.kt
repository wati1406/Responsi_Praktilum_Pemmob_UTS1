package com.example.responsi.network

import com.example.responsi.model.Game
import com.example.responsi.model.GameResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {


    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("search") searchQuery: String = ""
    ): GameResponse

    @GET("games/{id}")
    suspend fun getGameDetail(
        @Path("id") id: Int,
        @Query("key") apiKey: String
    ): Game

}
