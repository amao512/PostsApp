package com.aslnstbk.postsapp.utils.notifications

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.aslnstbk.postsapp.R
import com.aslnstbk.postsapp.presentation.MainActivity
import com.aslnstbk.postsapp.presentation.PUSH_NOTIFICATION_EXTRA

@SuppressLint("StaticFieldLeak")
object NotificationManager {

    private lateinit var context: Context

    private var counter: Int = 1

    fun init(applicationContext: Context) {
        context = applicationContext
        createNotificationChannel()
    }

    fun sendNotification(
        title: String,
        content: String
    ) {
        val notification: Notification = createNotification(title, content)
        val id = counter++

        NotificationManagerCompat.from(context).notify(id, notification)
    }

    private fun createNotification(
        title: String,
        content: String
    ): Notification = NotificationCompat.Builder(context, getChannelId())
        .setSmallIcon(R.drawable.ic_launcher_foreground)
        .setContentTitle(title)
        .setContentText(content)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(getPendingIntent(content = content))
        .build()

    private fun getChannelId(): String = context.packageName + ".push_channel"

    private fun getPendingIntent(content: String): PendingIntent {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra(PUSH_NOTIFICATION_EXTRA, content)

        return PendingIntent.getActivity(context, 0, intent, 0)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        val name = context.getString(R.string.app_name)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(getChannelId(), name, importance)

        val notificationManager: NotificationManager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}