package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.repository

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.StudentRemoteDataSource
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.dto.toStudent
class DefaultStudentRepository(
    private val remoteDataSource: StudentRemoteDataSource
) : StudentRepository {
    override fun getStudents(
        callback: (Result<List<Student>>) -> Unit
    ) {
        remoteDataSource.getStudents { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }
    override fun getStudent(
        id: Int,
        callback: (Result<Student>) -> Unit
    ) {
        remoteDataSource.getStudent(id) { result ->
            callback(result.map { it.toStudent() })
        }
    }
    override fun searchStudents(
        query: String,
        callback: (Result<List<Student>>) -> Unit
    ) {
        val normalizedQuery = query
            .trim()
            .replace(Regex("\\s+"), " ")

        val keywords = normalizedQuery.split(" ")
        val apiQuery = keywords.first()

        remoteDataSource.searchStudents(apiQuery) { result ->
            callback(
                result.map { users ->
                    val students = users.map { it.toStudent() }

                    if (keywords.size == 1) {
                        students
                    } else {
                        students.filter { student ->
                            student.name.contains(
                                normalizedQuery,
                                ignoreCase = true
                            )
                        }
                    }
                }
            )
        }
    }
}