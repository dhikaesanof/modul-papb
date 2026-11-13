package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.repository

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.StudentRemoteDataSource
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.dto.toStudent
class DefaultStudentRepository(
    private val remoteDataSource: StudentRemoteDataSource
) : StudentRepository {
    override suspend fun getStudents(): List<Student> =
        remoteDataSource.getStudents().map { it.toStudent() }
    override suspend fun getStudent(id: Int): Student =
        remoteDataSource.getStudent(id).toStudent()
    override suspend fun searchStudents(query: String): List<Student> =
        remoteDataSource.searchStudents(query).map { it.toStudent() }
}