package org.example.notification.service.notification_service

import org.example.notification.enums.NotificationChannel
import org.example.notification.models.Notification
import org.example.notification.strategy.notification_strategy.NotificationStrategy

class PushNotificationService : NotificationStrategy {
    override fun supports(channel: NotificationChannel) = channel == NotificationChannel.PUSH

    override suspend fun sendNotification(notification: Notification) {
        println("Sending notification by in-app notification")
    }
}