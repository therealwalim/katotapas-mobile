package com.mlp.project.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mlp.project.api.model.Product
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mlp.project.R
import kotlinx.android.synthetic.main.activity_product.view.*

class MyAdapter(val context: Context, val productList: List<Product>): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var price: TextView
        var productImage: ImageView

        init {
            name = itemView.name
            price = itemView.price
            productImage = itemView.productImage

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.activity_product, parent, false)
        return ViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = productList[position].name.toString()
        holder.price.text = productList[position].price.toString()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

}