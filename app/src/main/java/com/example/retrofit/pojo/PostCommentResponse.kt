package com.example.retrofit.pojo

data class PostCommentResponse(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)