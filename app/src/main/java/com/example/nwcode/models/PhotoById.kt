package com.example.nwcode.models

import com.google.gson.annotations.SerializedName

data class PhotoById (
    @SerializedName("id") val id : String? = null,
    @SerializedName("urls") var urls : Urls? = Urls()
    )