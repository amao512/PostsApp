package com.aslnstbk.postsapp.presentation.home.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aslnstbk.postsapp.R
import com.aslnstbk.postsapp.data.db.entities.PostEntity

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var authorFullNameTextView: TextView
    private lateinit var authorAvatarImageView: ImageView
    private lateinit var dateTextView: TextView
    private lateinit var contentTextView: TextView

    fun onBind(post: PostEntity) {
        initViews()
        processPost(post)
    }

    private fun initViews() {
        with(itemView) {
            authorFullNameTextView = findViewById(R.id.item_post_user_full_name_text_view)
            authorAvatarImageView = findViewById(R.id.item_post_user_avatar_image_view)
            dateTextView = findViewById(R.id.item_post_date_text_view)
            contentTextView = findViewById(R.id.item_post_content_text_view)
        }
    }

    private fun processPost(post: PostEntity) {
        contentTextView.text = post.contentText
        dateTextView.text = post.date
        authorFullNameTextView.text = post.authorName
    }
}