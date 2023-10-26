package com.example.retrofitwithcoroutin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithcoroutin.databinding.EachRowBinding
import com.example.retrofitwithcoroutin.model.Post

class PostAdapter(private val context: Context, private var postList: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item : Post = postList[position]
        holder.bindViews(item)
    }

    inner class ViewHolder(private val binding: EachRowBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindViews(item: Post) {
            binding.id.text = item.id.toString()
            binding.title.text = item.title
        }

    }

    fun setData(postList: ArrayList<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }

}