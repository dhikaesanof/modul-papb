package com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote

import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.dto.UserDto
import com.example.modulnavcompose_245150200111026muhammadramadhikaesanof.data.remote.dto.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StudentApiService {
    @GET("users")
    fun getUsers(
        @Query("limit") limit: Int = 10
    ): Call<UserResponse>
    @GET("users/{id}")
    fun getUser(
        @Path("id") id: Int
    ): Call<UserDto>
    @GET("users/search")
    fun searchUsers(
        @Query("q") query: String,
        @Query("limit") limit: Int = 0
    ): Call<UserResponse>
}