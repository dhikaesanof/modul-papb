//package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.source
//
//import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.model.Student
//
//class StudentLocalDataSource {
//    private val students = listOf(
//        Student(2026, "Alya Putri", "Teknik Informatika", 2026),
//        Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
//        Student(2028, "Citra Lestari", "Teknik Informatika", 2026),
//        Student(2029, "Dhika Esanof", "Teknik Informatika", 2026),
//        Student(2030, "Raffi Putra", "Teknologi Informasi", 2026)
//    )
//    fun getStudentById(id: Int): Student? =
//        students.find { it.id == id }
//    fun getStudents(): List<Student> = students
//}