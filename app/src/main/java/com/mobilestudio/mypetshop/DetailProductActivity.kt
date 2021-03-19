package com.mobilestudio.mypetshop

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mobilestudio.mypetshop.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailProductBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        intent?.extras?.let { bundle ->
            val name = bundle.getString(KEY_NAME, "")
            val price = bundle.getString(KEY_PRICE, "")

            Log.e("NAME", name)
            Log.e("PRICE", price)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_PRICE, "afdasf")
    }

    companion object {
        val KEY_NAME = "KEY_NAME"
        val KEY_PRICE = "KEY_PRICE"
    }

}