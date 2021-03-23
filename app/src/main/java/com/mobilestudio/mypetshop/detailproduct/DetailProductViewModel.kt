package com.mobilestudio.mypetshop.detailproduct

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DetailProductViewModel(application: Application) : AndroidViewModel(application) {

    private val mutableQuantity = MutableLiveData<Int>()
    val quantity: LiveData<Int>
        get() = mutableQuantity

    init {
        mutableQuantity.value = 1
    }

    fun addQuantity() {
        // ++
        mutableQuantity.value = mutableQuantity.value?.plus(1)
    }

    fun minusQuantity() {
        // --
        val helperQuantity = mutableQuantity.value ?: 0
        if (helperQuantity > 0) {
            mutableQuantity.value = mutableQuantity.value?.minus(1)
        }
    }

}