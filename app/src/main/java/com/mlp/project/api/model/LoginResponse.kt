package com.mlp.project.api.model

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("token")
    var token: String
)