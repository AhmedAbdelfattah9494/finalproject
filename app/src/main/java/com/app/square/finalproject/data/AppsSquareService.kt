package com.app.square.finalproject.data

import com.app.square.finalproject.ui.login.model.LoginResponse
import com.app.square.finalproject.ui.login.ui.products.model.Products
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

internal interface AppsSquareService {
    @FormUrlEncoded
    @POST("api/login")
    fun login(@Field("email") email: String,@Field("password") password:String): Call<LoginResponse>

    @FormUrlEncoded
    @POST("api/sign_up")
    fun signup(@Field("name") name: String, @Field("email") email: String, @Field("password") password:String): Call<LoginResponse>

    @GET("api/products")
    fun products(): Call<Products>

    companion object {
        val retrofitClient: AppsSquareService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://android-training.appssquare.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(AppsSquareService::class.java)
        }
    }
}