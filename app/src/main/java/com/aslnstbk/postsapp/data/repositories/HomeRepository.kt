package com.aslnstbk.postsapp.data.repositories

import androidx.lifecycle.LiveData
import com.aslnstbk.postsapp.data.db.PostDataSource
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import com.aslnstbk.postsapp.domain.HomeDomainRepository
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val postDataSource: PostDataSource
) : HomeDomainRepository {

    override fun getAllPosts(): LiveData<List<PostEntity>> = postDataSource.allPosts

    override fun deletePost(postEntity: PostEntity) {
        postDataSource.deleteAddress(postEntity)
    }

    override fun updatePost(postEntity: PostEntity) {}
}