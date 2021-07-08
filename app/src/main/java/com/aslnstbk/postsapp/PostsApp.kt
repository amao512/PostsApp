package com.aslnstbk.postsapp

import android.app.Application
import com.aslnstbk.postsapp.utils.notifications.NotificationManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PostsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        NotificationManager.init(applicationContext = this)
    }
}