package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.repository.StudentRepository
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val refreshRequests = MutableSharedFlow<String>()
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
    }

    @OptIn(FlowPreview::class)
    private fun observeSearch() {
        viewModelScope.launch {
            val typedQueries = searchQuery
                .map { it.trim() }
                .debounce(500)
                .distinctUntilChanged()

            merge(typedQueries, refreshRequests)
                .collectLatest { query ->
                    loadProfiles(query)
                }
        }
    }

    init {
        observeSearch()
    }

    fun refresh() {
        val query = searchQuery.value.trim()

        viewModelScope.launch {
            refreshRequests.emit(query)
        }
    }

    fun retry() {
        refresh()
    }

    private suspend fun loadProfiles(query: String) {
        _uiState.value = _uiState.value.copy(
            isLoading = true,
            errorMessage = null
        )

        try {
            val students = if (query.isBlank()) {
                repository.getStudents()
            } else {
                repository.searchStudents(query)
            }

            _uiState.value = HomeUiState(students = students)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            _uiState.value = HomeUiState(
                errorMessage = e.message ?: "Gagal mengambil data"
            )
        }
    }

    companion object {
        fun factory(repository: StudentRepository): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(repository) as T
                }
            }
    }
}