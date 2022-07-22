package com.example.nwcode.models

import com.google.gson.annotations.SerializedName

data class CoverPhoto(
    @SerializedName("id"                       ) var id                     : String?           = null,
    @SerializedName("description"              ) var description            : String?           = null,
    @SerializedName("urls"                     ) var urls                   : Urls?             = Urls(),
    @SerializedName("links"                    ) var links                  : Links?            = Links(),
    @SerializedName("categories"               ) var categories             : ArrayList<String> = arrayListOf()
)
