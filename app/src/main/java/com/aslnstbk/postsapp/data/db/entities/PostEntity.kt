package com.aslnstbk.postsapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post_table")
data class PostEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "author_name")
    val authorName: String? = null,
    @ColumnInfo(name = "date")
    val date: String? = null,
    @ColumnInfo(name = "content_text")
    val contentText: String? = null
)