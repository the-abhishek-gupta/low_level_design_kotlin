package org.example.notification

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.example.notification.enums.NotificationChannel
import org.example.notification.models.Notification
import org.example.notification.service.NotificationRouter
import org.example.notification.service.RetryService
import org.example.notification.service.notification_service.EmailNotificationService
import org.example.notification.service.notification_service.PushNotificationService
import org.example.notification.service.notification_service.SMSNotificationService
import org.example.notification.service.user_preference.DefaultUserPreference

class NotificationMain {
    fun main() = runBlocking {
        val notificationServices = listOf(
            SMSNotificationService(),
            PushNotificationService(),
            EmailNotificationService()
        )

        val router = NotificationRouter(notificationServices)

        val preferenceService = DefaultUserPreference()

        val retryService = RetryService()

        val manager = NotificationManager(
            router = router,
            preferenceService = preferenceService,
            retryService = retryService,
        )

        val notification = Notification(
            recipientId = "abhi123",
            title = "Item arrived", message = "Your item has arrived", channels = listOf(NotificationChannel.PUSH)
        )
        manager.sendNotification(notification)

        delay(1000)
    }
}