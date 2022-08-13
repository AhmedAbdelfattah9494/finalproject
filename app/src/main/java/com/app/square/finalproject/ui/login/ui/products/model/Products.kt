package com.app.square.finalproject.ui.login.ui.products.model

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("data")
    val `data`: List<Product>?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Boolean?
)