package notification.strategy.notification_strategy

import notification.enums.NotificationChannel
import notification.models.Notification

class EmailNotificationService : NotificationStrategy {
    override fun supports(channel: NotificationChannel) = channel == NotificationChannel.EMAIL

    override suspend fun sendNotification(notification: Notification) {
        println("Sending notification by email")
    }
}