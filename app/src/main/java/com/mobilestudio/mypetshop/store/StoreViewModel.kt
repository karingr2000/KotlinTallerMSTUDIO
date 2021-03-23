package com.mobilestudio.mypetshop.store

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mobilestudio.mypetshop.R
import com.mobilestudio.mypetshop.models.Product
import com.mobilestudio.repository.ProductsRepository
import kotlinx.coroutines.launch

class StoreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProductsRepository(application)

    private val mutableListProducts = MutableLiveData<List<Product>?>()
    val listProducts: LiveData<List<Product>?>
        get() = mutableListProducts

    fun getAllCartProducts() {
        Log.i("VIEWMODEL", "START CALL")
        viewModelScope.launch {
            val productListFromRepo = repository.getAllProductsInCart()
            Log.i("VIEWMODEL", "from repo result")
            Log.i("VIEWMODEL", "$productListFromRepo")
            mutableListProducts.value = productListFromRepo?.map {
                Product(it.name, "${it.price}", R.drawable.ic_app)
            }
        }
    }

    fun addProduct(name: String, price: String) {
        viewModelScope.launch {
            repository.addProductToCart(name, price)
        }
    }

}