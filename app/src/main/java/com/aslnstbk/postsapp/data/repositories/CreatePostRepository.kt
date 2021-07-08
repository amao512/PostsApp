package com.aslnstbk.postsapp.data.repositories

import com.aslnstbk.postsapp.data.db.PostDataSource
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import com.aslnstbk.postsapp.domain.CreatePostDomainRepository
import javax.inject.Inject

class CreatePostRepository @Inject constructor(
    private val postDataSource: PostDataSource
) : CreatePostDomainRepository {

    override suspend fun addPost(postEntity: PostEntity) {
        postDataSource.insertAddress(postEntity)
    }
}