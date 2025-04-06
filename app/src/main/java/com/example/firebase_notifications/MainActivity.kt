package com.example.firebase_notifications

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.firebase_notifications.ui.theme.Firebase_NotificationsTheme
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         lateinit var firebaseAnalytics: FirebaseAnalytics

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, Bundle().apply {
            putString(FirebaseAnalytics.Param.SCREEN_NAME, "MainScreen")
            putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity")
        })
        if (intent.extras != null) {
            if (intent.extras!!.containsKey("from_notification")) {
                firebaseAnalytics.logEvent("notification_opened", null)
            }
        }
        FirebaseAnalytics.getInstance(this).logEvent("notification_opened", null)
        enableEdgeToEdge()
            FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val token = task.result
                    Log.d("FCM", "Token: $token")
                } else {
                    Log.w("FCM", "Fetching FCM registration token failed", task.exception)
                }
            }
        setContent {
            Firebase_NotificationsTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Button(onClick = {
                    firebaseAnalytics.logEvent("button_clicked", Bundle().apply {
                        putString("button_name", "TestNotificationButton")

                    })
                        Log.d("Analytics", "Button tapped event triggered")

                    })
                    {
                    Text(text = "Tap Me")
                }
                }
            }
        }
    }
}

