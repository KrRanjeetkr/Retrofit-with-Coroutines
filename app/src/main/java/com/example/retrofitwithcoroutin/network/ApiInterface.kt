package com.example.retrofitwithcoroutin.network

import com.example.retrofitwithcoroutin.model.Post
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPost() : List<Post>

}