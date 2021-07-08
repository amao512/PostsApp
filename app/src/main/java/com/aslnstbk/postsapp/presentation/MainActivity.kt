package com.aslnstbk.postsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aslnstbk.postsapp.R
import dagger.hilt.android.AndroidEntryPoint

const val PUSH_NOTIFICATION_EXTRA = "push_notification_extra"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}