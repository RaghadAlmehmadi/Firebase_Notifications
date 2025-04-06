# Firebase_Notifications

This project demonstrates the integration of Firebase Cloud Messaging (FCM) and Firebase Analytics in an Android app built using Jetpack Compose.
It supports real-time push notifications and tracks various in-app and notification-based events.

#  Steps to Run the Project

- Clone the Repository

- Open in Android Studio

- Set Up Firebase

- Sync Gradle

- Run the App

- Enable Debug Analytics Logging

# Firebase Cloud Messaging (FCM)

## Implemented Features:

- FCM token generated and logged on app start.

- Custom Firebase Messaging Service to handle notifications.

- Notifications displayed in system tray using NotificationCompat.

- Tap on notification opens the app and logs an event.

## How It Was Tested:
- Test notifications were sent via Firebase Console.

**Verified by checking:**

- Logcat outputs (Log.d)

- Notification received in system tray

- Token printed in logs

 ## Firebase Analytics - Events Tracked
- app_opened – Automatically triggered when the app is launched.

- screen_view – Logged when the user lands on the MainActivity screen.

- notification_received – Logged when a push notification is received by the FCM service.

- notification_opened – Logged when the app is opened by tapping on a notification.

- button_clicked – Logged when the user taps the “Tap Me” button in the UI.


## How It Was Tested:

- Used Firebase DebugView to monitor real-time events.

- Verified event parameters (like message content).

# Screenshots

## Screenshots for notification 

![image](https://github.com/user-attachments/assets/b02f60d6-6963-4699-a45a-ac7d9e92abf1)

## Screenshots for logcat massages 

![image](https://github.com/user-attachments/assets/f819ac0d-4ad6-4b86-bab9-88de486194c3)

## Screenshots for Firebase Analytics DebugView

![image](https://github.com/user-attachments/assets/1fd686a8-46bf-4105-a6ae-75fe7c34b52d)

