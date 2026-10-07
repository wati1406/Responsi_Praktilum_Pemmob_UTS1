package com.example.responsi.repository

import com.example.responsi.model.Game
import com.example.responsi.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GameRepository {
    private val apiKey = "20ffeb0dc79448208bb17ac87de3bb01"
    private val apiService = ApiClient.apiService

    suspend fun getGames(searchQuery: String = ""): List<Game> {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getGames(apiKey = apiKey, searchQuery = searchQuery)
                response.results
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    suspend fun getGameDetail(id: Int): Game? {
        return withContext(Dispatchers.IO) {
            try {
                apiService.getGameDetail(id = id, apiKey = apiKey)
            } catch (e: Exception) {
                null
            }
        }
    }
}
