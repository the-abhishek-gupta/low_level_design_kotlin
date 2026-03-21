package notification.strategy.notification_strategy

import notification.enums.NotificationChannel
import notification.models.Notification

class PushNotificationService : NotificationStrategy {
    override fun supports(channel: NotificationChannel) = channel == NotificationChannel.PUSH

    override suspend fun sendNotification(notification: Notification) {
        println("Sending notification by in-app notification")
    }
}