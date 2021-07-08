package com.aslnstbk.postsapp.domain

import com.aslnstbk.postsapp.data.db.entities.PostEntity

interface CreatePostDomainRepository {

    suspend fun addPost(postEntity: PostEntity)
}