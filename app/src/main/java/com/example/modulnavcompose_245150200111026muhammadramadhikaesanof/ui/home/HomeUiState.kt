package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.home

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student

data class HomeUiState(
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val searchQuery: String = ""
)