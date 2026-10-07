package com.example.responsi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi.model.Game
import com.example.responsi.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val repository = GameRepository()

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    private val _selectedGame = MutableStateFlow<Game?>(null)
    val selectedGame: StateFlow<Game?> = _selectedGame.asStateFlow()

    init {
        fetchGames()
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        fetchGames(query)
    }

    private fun fetchGames(query: String = "") {
        viewModelScope.launch {
            _isLoading.value = true
            val results = repository.getGames(query)
            _games.value = results
            _isLoading.value = false
        }
    }
    
    fun fetchGameDetail(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = repository.getGameDetail(id)
            _selectedGame.value = result
            _isLoading.value = false
        }
    }
    
    fun clearSelectedGame() {
        _selectedGame.value = null
    }
}
