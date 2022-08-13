package com.app.square.finalproject.ui.login.ui.register

import com.app.square.finalproject.ui.core.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class RegistrationResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)