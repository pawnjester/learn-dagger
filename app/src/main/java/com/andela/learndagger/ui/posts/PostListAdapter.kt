package com.andela.learndagger.ui.posts

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.andela.learndagger.R
import com.andela.learndagger.databinding.SinglePostLayoutBinding
import com.andela.learndagger.models.Post

class PostListAdapter: RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    private var posts = mutableListOf<Post>()

    fun updateList (update: List<Post>) {
        posts.clear()
        posts.addAll(update)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            PostListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<SinglePostLayoutBinding>(
                inflater, R.layout.single_post_layout, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostListAdapter.ViewHolder, position: Int) {
        val items = posts[position]
        holder.bind(items)
    }

    inner class ViewHolder(val binding: SinglePostLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind (item: Post) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}