package com.app.square.finalproject.ui.login.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.square.finalproject.R
import com.app.square.finalproject.data.Repository
import com.app.square.finalproject.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductsViewModel() : ViewModel() {

    private val _productsResult = MutableLiveData<ProductsResult>()
    val productsResult: LiveData<ProductsResult> = _productsResult

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO){
            val result = Repository().products()

            if (result is Result.Success) {
                _productsResult.postValue(ProductsResult(success = result.data.data))
            } else {
                _productsResult.postValue(ProductsResult(error = R.string.login_failed))
            }
        }
    }
}