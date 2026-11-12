package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.dto

data class UserResponse(
    val users: List<UserDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)