package com.example.retrofitwithcoroutin.repository

import com.example.retrofitwithcoroutin.model.Post
import com.example.retrofitwithcoroutin.network.RetrofitInstance

class PostRepository {

    suspend fun getPost() : List<Post> = RetrofitInstance.api.getPost()

}