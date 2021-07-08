package com.aslnstbk.postsapp.domain

import androidx.lifecycle.LiveData
import com.aslnstbk.postsapp.data.db.entities.PostEntity

interface HomeDomainRepository {

    fun getAllPosts(): LiveData<List<PostEntity>>

    fun deletePost(postEntity: PostEntity)

    fun updatePost(postEntity: PostEntity)
}