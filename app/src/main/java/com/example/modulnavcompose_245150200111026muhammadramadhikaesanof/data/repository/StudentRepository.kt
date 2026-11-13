package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.repository

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student

interface StudentRepository {
    suspend fun getStudents(): List<Student>
    suspend fun getStudent(id: Int): Student
    suspend fun searchStudents(query: String): List<Student>
}