package com.app.square.finalproject.ui.login.ui.products

import com.app.square.finalproject.ui.login.ui.products.model.Product

data class ProductsResult(
    val success: List<Product>? = null,
    val error: Int? = null
)