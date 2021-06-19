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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product.view.*

class MyAdapter(val context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    private var productList: List<Product> = emptyList()

    fun setProductList(list: List<Product>) {
        productList = list
    }

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
        val itemView = LayoutInflater.from(context).inflate(R.layout.activity_product, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = productList[position].name
        holder.price.text = productList[position].price.toString().plus(" $")

        val url = "https://katobackend.azurewebsites.net/" + productList[position].productImage

        Picasso.get()
            .load(url)
            .into(holder.productImage)

    }

    override fun getItemCount(): Int {
        return productList.size
    }

}