package org.example.notification.strategy.notification_strategy

import org.example.notification.enums.NotificationChannel
import org.example.notification.models.Notification

interface NotificationStrategy {
    fun supports(channel: NotificationChannel): Boolean
    suspend fun sendNotification(notification: Notification)
}