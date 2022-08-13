package com.app.square.finalproject.ui.login.ui.login

import com.app.square.finalproject.ui.core.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)