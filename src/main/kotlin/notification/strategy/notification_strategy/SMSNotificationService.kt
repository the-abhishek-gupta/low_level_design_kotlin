package notification.strategy.notification_strategy

import notification.enums.NotificationChannel
import notification.models.Notification

class SMSNotificationService : NotificationStrategy {
    override fun supports(channel: NotificationChannel) = channel == NotificationChannel.SMS

    override suspend fun sendNotification(notification: Notification) {
        println("Sending notification by SMS")
    }
}