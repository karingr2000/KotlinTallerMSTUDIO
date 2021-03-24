package com.mobilestudio.mypetshop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobilestudio.mypetshop.R
import com.mobilestudio.mypetshop.databinding.ItemCategoryBinding

class AdapterCart(
    private val dataSource: List<String>
) : RecyclerView.Adapter<AdapterCart.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            parent.createItemCategoryBinding()
        )
    }

    private fun ViewGroup.createItemCategoryBinding() = ItemCategoryBinding.inflate(
        LayoutInflater.from(this.context),
        this,
        false
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(data = dataSource[position])
    }

    override fun getItemCount(): Int = dataSource.size

    class ViewHolder(private val itemCategory: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemCategory.root) {

        fun bindView(data: String) {
            itemCategory.txtItemCategory.text = data
            itemCategory.imgItemCategory.setImageResource(R.drawable.ic_app)
        }
    }
}