package com.example.retrofittest.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class urlImageModel {
    @SerializedName("file")
    @Expose
    var file: String? = null
}