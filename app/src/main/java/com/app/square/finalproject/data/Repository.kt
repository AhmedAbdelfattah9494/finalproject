package com.app.square.finalproject.data

import com.app.square.finalproject.data.AppsSquareService.Companion.retrofitClient
import com.app.square.finalproject.data.model.LoggedInUser
import com.app.square.finalproject.ui.login.ui.products.model.Products
import java.io.IOException


class Repository {

    suspend fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        val response = retrofitClient.login(username, password).execute()
        return if (response.isSuccessful) Result.Success(LoggedInUser(response.body()!!.data.id, response.body()!!.data.name))
        else Result.Error(IOException(response.message()))
    }

    suspend fun register(email: String, username: String, password: String): Result<LoggedInUser> {
        // handle registration
        val response = retrofitClient.signup(email,username, password).execute()
        return if (response.isSuccessful) Result.Success(LoggedInUser(response.body()!!.data.id, response.body()!!.data.name))
        else Result.Error(IOException(response.message()))
    }

    suspend fun products(): Result<Products> {
        // handle products
        val response = retrofitClient.products().execute()
        return if (response.isSuccessful) Result.Success(response.body()!!)
        else Result.Error(IOException(response.message()))
    }
}