package com.mobilestudio.mypetshop.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mobilestudio.mypetshop.R
import com.mobilestudio.mypetshop.adapters.AdapterCart
import com.mobilestudio.mypetshop.adapters.AdapterCategory
import com.mobilestudio.mypetshop.databinding.ActivityCartBinding
import com.mobilestudio.mypetshop.databinding.ActivityDetailProductBinding
import com.mobilestudio.mypetshop.models.Product

class CartActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityCartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getAllCartProducts()

        setUpActions()
        setUpObservables()
    }

    private val viewModel by viewModels<CartViewModel>()



    private fun setUpActions() {


    }


    private fun setUpObservables() {
        viewModel.listProducts.observe(this, Observer { ListProducts ->
          val productsName =  ListProducts?.map { it.name  }

          val adapterCart = AdapterCart(productsName?: listOf())
          binding.rvCartList.adapter = adapterCart
        })

    }

}