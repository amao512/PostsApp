package com.aslnstbk.postsapp.presentation.home.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aslnstbk.postsapp.R
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import com.aslnstbk.postsapp.utils.BaseDiffUtilCallBack

class PostsAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private val currentList: MutableList<PostEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size

    fun updateList(list: List<PostEntity>) {
        val diffCallback = getDiffUtilCallBack(list)

        val diffResult = DiffUtil.calculateDiff(diffCallback)
        currentList.clear()
        currentList.addAll(list)
        diffResult.dispatchUpdatesTo(this)
    }

    private fun getDiffUtilCallBack(list: List<Any>): BaseDiffUtilCallBack {
        return object : BaseDiffUtilCallBack(currentList, list) {
            override fun getAreContentsTheSame(
                oldItemPosition: Int,
                newItemPosition: Int
            ): Boolean {
                return (currentList[oldItemPosition]).id == (list[newItemPosition] as PostEntity).id
            }
        }
    }
}