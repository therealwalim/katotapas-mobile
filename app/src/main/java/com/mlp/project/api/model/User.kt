package com.mlp.project.api.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("_id")
    var id: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("password")
    var password: String
)