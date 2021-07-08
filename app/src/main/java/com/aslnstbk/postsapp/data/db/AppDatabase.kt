package com.aslnstbk.postsapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aslnstbk.postsapp.data.db.entities.PostEntity

@Database(entities = [PostEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "posts_database"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance

                return instance
            }
        }
    }
}