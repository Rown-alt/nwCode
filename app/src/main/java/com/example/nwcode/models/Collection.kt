package com.example.nwcode.models

import com.google.gson.annotations.SerializedName

data class Collection (
    @SerializedName("total"       ) var total      : Int?               = null,
    @SerializedName("total_pages" ) var totalPages : Int?               = null,
    @SerializedName("results"     ) var results    : List<Results>      = listOf()
        )