package com.mobilestudio.mypetshop

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mobilestudio.mypetshop.adapters.AdapterCategory
import com.mobilestudio.mypetshop.databinding.ActivityStoreBinding

class StoreActivity : AppCompatActivity() {

    private val binding: ActivityStoreBinding by lazy {
        Log.e("MENSAJE", "HELLO LAZY!!")
        ActivityStoreBinding.inflate(layoutInflater)
    }

    private val adapterCategory = AdapterCategory(getCategoryProducts())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rcCategory.adapter = adapterCategory

    }


    private fun getCategoryProducts(): List<String> {
        val listCategories = mutableListOf<String>()
        listCategories.add("Food")
        listCategories.add("Toys")
        listCategories.add("Accessories")
        return listCategories
    }
}