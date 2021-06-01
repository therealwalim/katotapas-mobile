package com.mlp.project.api.model

import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("_id")
    var _id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("price")
    var price: Number,

    @SerializedName("productImage")
    var productImage: String
)