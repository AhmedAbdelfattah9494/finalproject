package com.app.square.finalproject.ui.login.ui.register

/**
 * Data validation state of the login form.
 */
data class RegistrationFormState(
    val usernameError: Int? = null,
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false
)