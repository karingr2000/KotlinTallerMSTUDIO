package com.mobilestudio.mypetshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.mypetshop.databinding.ItemProductBinding
import com.mobilestudio.mypetshop.models.Product

class AdapterProducts(private val dataSource: List<Product>) :
    RecyclerView.Adapter<AdapterProducts.ViewHolder>() {

    lateinit var onClick: (Product) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = dataSource[position]
        holder.binding(product)
        holder.itemView.setOnClickListener {
            onClick(product)
        }
    }

    override fun getItemCount(): Int = dataSource.size

    fun setOnItemClick(block: (Product) -> Unit) {
        onClick = block
    }

    class ViewHolder(private val bindingView: ItemProductBinding) :
        RecyclerView.ViewHolder(bindingView.root) {
        fun binding(data: Product) {
            bindingView.imgItemProduct.setImageResource(data.img)
            bindingView.txtProductName.text = data.name
            bindingView.txtProductPrice.text = data.price
        }
    }
}
