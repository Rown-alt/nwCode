package com.example.nwcode.api

import com.example.nwcode.models.Collection
import com.example.nwcode.models.PhotoById
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashAPI {
    @GET("topics/{name}/photos?client_id=if7P4swvWbVeYKGDB6gf2TSCS-WE6Dn_hd4lcDdziUY")
    suspend fun getTopics(@Query("name") name : String)
    @GET("photos/{id}?client_id=if7P4swvWbVeYKGDB6gf2TSCS-WE6Dn_hd4lcDdziUY")
    suspend fun getPhoto(@Path("id") id : String) : Result<PhotoById>
    @GET("search/collections?client_id=if7P4swvWbVeYKGDB6gf2TSCS-WE6Dn_hd4lcDdziUY")
    suspend fun getCollections(@Query("query") query : String) : Result<Collection>
}