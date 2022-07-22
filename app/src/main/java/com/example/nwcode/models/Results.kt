package com.example.nwcode.models

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("id"                ) var id              : String?                  = null,
    @SerializedName("title"             ) var title           : String?                  = null,
    @SerializedName("description"       ) var description     : String?                  = null,
    @SerializedName("total_photos"      ) var totalPhotos     : Int?                     = null,
    @SerializedName("cover_photo"       ) var coverPhoto      : CoverPhoto?              = CoverPhoto(),
    @SerializedName("preview_photos"    ) var previewPhotos   : ArrayList<PreviewPhotos> = arrayListOf()
        )