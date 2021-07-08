package com.aslnstbk.postsapp.data.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.aslnstbk.postsapp.data.db.entities.PostEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

open class PostDataSource @Inject constructor(
    @ApplicationContext context: Context
) {

    private val postDao: PostDao

    open val allPosts: LiveData<List<PostEntity>>

    init {
        val db = AppDatabase.getInstance(context)

        postDao = db.postDao()
        allPosts = postDao.all
    }

    fun insertAddress(item: PostEntity) {
        postDao.insert(item)
    }

    fun deleteAddress(item: PostEntity) {
        postDao.delete(id = item.id ?: 0)
    }

    fun updateAddress(item: PostEntity) {
        postDao.update(item)
    }
}