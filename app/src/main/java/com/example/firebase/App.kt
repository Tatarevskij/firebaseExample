package com.example.firebase

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.crashlytics.FirebaseCrashlytics

class App: Application() {

    override fun onCreate() {
        super.onCreate()
      //  FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(!BuildConfig.DEBUG)
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
        val name = "Test notification channel"
        val descriptionText = "This is a simple description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    companion object{
        const val NOTIFICATION_CHANNEL_ID = "test_channel_id"
    }
}

/* Запрос в postman
POST https://fcm.googleapis.com/v1/projects/fir-test-project-42f12/messages:send
token в консоли

на гугл девопс
OAuth 2.0 Playground добавить:
https://www.googleapis.com/auth/firebase.messaging
получить accessToken и вставить его в постман перед отправкой сооббщения(вкладка authorization)
Запрос на вкладке Body, raw, формат JSON:
{
    "message":{
    "token": "fhkXBcZET22yQzIadFD2Yx:APA91bFcw4sxrPaheLnJA8olQSz7tCHgCAIO4SFUk2o1yci7vSEsfVnn4PZNwjZaz3XJARdobX6QeA6zrwFsNnAePIpi9t5rlplNAA_U_6VRAD6mKEb845dTeHBpWfp7XRh5S532IFu0",
    "data":{
    "nickname":"Doc Brown",
    "message":"Hi Marty from 2030",
    "timestamp":"1893477600"
}
}
}*/
