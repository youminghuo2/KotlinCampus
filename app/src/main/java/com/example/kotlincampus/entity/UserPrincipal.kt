package com.example.kotlincampus.entity

data class UserPrincipal(
    val headImageUrl: String,
    val id: Int,
    val mobile: String,
    val name: String,
    val userType: String,
    val username: String
)