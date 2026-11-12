package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.detail

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student
data class DetailUiState(
    val student: Student? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)