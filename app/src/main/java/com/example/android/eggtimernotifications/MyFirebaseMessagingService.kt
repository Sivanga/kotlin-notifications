package com.example.android.eggtimernotifications

import android.app.NotificationManager
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.android.eggtimernotifications.util.sendNotification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * User: sivangalamidi
 * Date: 16/9/2021
 * Time: 2:34 PM
 */
class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.d(TAG, "From: ${remoteMessage?.from}")

        remoteMessage?.data?.let{
            Log.d(TAG, "Message data payload: ${remoteMessage.data}")
        }

        remoteMessage?.notification?.let {
            Log.d(TAG, "Message notification body: ${it.body} ")
            sendNotification(it.body!!)
        }
    }

    private fun sendNotification(body: String) {
        val notificationManager = ContextCompat.getSystemService(applicationContext,
            NotificationManager::class.java) as NotificationManager

        notificationManager.sendNotification(body, applicationContext)
    }

    override fun onNewToken(token: String) {
        Log.d(TAG, "token: ${token}")

        sendRegistrationToServer(token)
    }

    private fun sendRegistrationToServer(token: String) {
        TODO("Not yet implemented")
    }

    companion object {
        private const val TAG = "MyFirebaseMessaging"
    }

}
