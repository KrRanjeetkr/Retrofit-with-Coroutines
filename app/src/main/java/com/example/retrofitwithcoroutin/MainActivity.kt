package com.example.retrofitwithcoroutin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitwithcoroutin.adapter.PostAdapter
import com.example.retrofitwithcoroutin.databinding.ActivityMainBinding
import com.example.retrofitwithcoroutin.model.Post
import com.example.retrofitwithcoroutin.repository.PostRepository
import com.example.retrofitwithcoroutin.viewModel.PostViewModel
import com.example.retrofitwithcoroutin.viewModel.PostViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecyclerView()

        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this) {
            postAdapter.setData(it as ArrayList<Post>)
            binding.progress.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        }

    }

    private fun initRecyclerView() {
        postAdapter = PostAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }

}