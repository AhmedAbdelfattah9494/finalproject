package com.app.square.finalproject.ui.login.model

data class LoginResponse(
    val `data`: Data,
    val message: String,
    val status: Boolean,
    val token: String
)