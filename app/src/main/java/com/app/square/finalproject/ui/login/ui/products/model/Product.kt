package com.app.square.finalproject.ui.login.ui.products.model


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("quantity")
    val quantity: Int?,
    @SerializedName("restaurant_id")
    val restaurantId: Int?
)