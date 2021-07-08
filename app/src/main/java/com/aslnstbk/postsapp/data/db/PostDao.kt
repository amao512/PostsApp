package com.aslnstbk.postsapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aslnstbk.postsapp.data.db.entities.PostEntity

@Dao
interface PostDao {

    @get:Query("SELECT * from post_table")
    val all: LiveData<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: PostEntity)

    @Query("DELETE FROM post_table WHERE id = :id")
    fun delete(id: Int)

    @Update
    fun update(post: PostEntity)
}