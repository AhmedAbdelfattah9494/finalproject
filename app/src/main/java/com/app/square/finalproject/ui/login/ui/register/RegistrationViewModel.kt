package com.app.square.finalproject.ui.login.ui.register

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.square.finalproject.R
import com.app.square.finalproject.data.Repository
import com.app.square.finalproject.data.Result
import com.app.square.finalproject.ui.core.LoggedInUserView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel() : ViewModel() {

    private val _registerForm = MutableLiveData<RegistrationFormState>()
    val registrationFormState: LiveData<RegistrationFormState> = _registerForm

    private val _registerResult = MutableLiveData<RegistrationResult>()
    val registerResult: LiveData<RegistrationResult> = _registerResult

    fun signup(username: String, email: String, password: String) {
        // can be launched in a separate asynchronous job
      viewModelScope.launch(Dispatchers.IO){
          val result = Repository().register(email,username, password)

          if (result is Result.Success) {
              _registerResult.postValue(RegistrationResult(success = LoggedInUserView(result.data.displayName, result.data.userId)))
          } else {
              _registerResult.postValue(RegistrationResult(error = R.string.signup_failed))
          }
      }
    }

   
    fun signupDataChanged(email: String, username: String, password: String) {
        if (!isEmailValid(email)) {
            _registerForm.value = RegistrationFormState(emailError = R.string.invalid_email)
        } else if (!isUsernameValid(username)) {
            _registerForm.value = RegistrationFormState(usernameError = R.string.invalid_field)
        } else if (!isPasswordValid(password)) {
            _registerForm.value = RegistrationFormState(passwordError = R.string.invalid_field)
        } else {
            _registerForm.value = RegistrationFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isEmailValid(email: String): Boolean {
        return  (Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.isNotBlank())
    }

    private fun isUsernameValid(username: String): Boolean {
        return username.length > 5
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}