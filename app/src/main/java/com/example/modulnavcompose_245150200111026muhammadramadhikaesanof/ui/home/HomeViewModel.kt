package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.repository.StudentRepository
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student

class HomeViewModel(
    private val repository: StudentRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    private var lastSubmittedQuery = ""

    init {
        loadStudents()
    }

    fun onSearchQueryChange(query: String) {
        uiState = uiState.copy(searchQuery = query)
    }

    fun loadStudents() {
        requestStudents("")
    }

    fun searchStudents() {
        requestStudents(uiState.searchQuery.trim())
    }

    fun retry() {
        requestStudents(lastSubmittedQuery)
    }

    private fun requestStudents(query: String) {
        if (uiState.isLoading) return

        lastSubmittedQuery = query

        uiState = uiState.copy(
            isLoading = true,
            errorMessage = null
        )

        val callback: (Result<List<Student>>) -> Unit = { result ->
            result
                .onSuccess { students ->
                    uiState = uiState.copy(
                        students = students,
                        isLoading = false,
                        errorMessage = null
                    )
                }
                .onFailure { error ->
                    uiState = uiState.copy(
                        students = emptyList(),
                        isLoading = false,
                        errorMessage = error.message
                            ?: "Gagal mengambil data"
                    )
                }
        }

        if (query.isBlank()) {
            repository.getStudents(callback)
        } else {
            repository.searchStudents(query, callback)
        }
    }
}