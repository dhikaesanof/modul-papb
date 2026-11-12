package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.ui.detail.DetailUiState

@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Detail Student", style = MaterialTheme.typography.headlineMedium)
        when {
            uiState.student != null -> {
                val student = uiState.student
                Text("ID: ${student.id}")
                Text(
                    student.name,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text("Email: ${student.email}")
                Text("University: ${student.university}")
            }
        }
        Button(onClick = onBack) {
            Text("Kembali")
        }
    }
}