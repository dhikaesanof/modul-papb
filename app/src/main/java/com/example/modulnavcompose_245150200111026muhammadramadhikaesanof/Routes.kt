package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof;

object Routes {
    const val HOME = "home"
    const val PROFILE = "profile"
    const val DETAIL = "detail/{studentId}"
    fun detail(studentId: Int): String = "detail/$studentId"
    const val ABOUT = "about"
}
