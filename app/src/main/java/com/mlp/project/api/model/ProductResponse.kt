package com.mlp.project.api.model

import com.google.gson.annotations.SerializedName

data class ProductResponse (
    @SerializedName("count")
    var count: Int,

    @SerializedName("products")
    var products: List<Product>
)