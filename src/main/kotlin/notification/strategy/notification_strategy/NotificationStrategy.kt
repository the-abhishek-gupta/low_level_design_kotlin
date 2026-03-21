package notification.strategy.notification_strategy

import notification.enums.NotificationChannel
import notification.models.Notification

interface NotificationStrategy {
    fun supports(channel: NotificationChannel): Boolean
    suspend fun sendNotification(notification: Notification)
}