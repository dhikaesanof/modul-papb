package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.repository

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student

interface StudentRepository {
    fun getStudents(callback: (Result<List<Student>>) -> Unit)
    fun getStudent(id: Int, callback: (Result<Student>) -> Unit)

    fun searchStudents(
        query: String,
        callback: (Result<List<Student>>) -> Unit
    )
}