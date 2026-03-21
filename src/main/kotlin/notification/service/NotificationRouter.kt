package notification.service

import notification.enums.NotificationChannel
import notification.models.Notification
import notification.strategy.notification_strategy.NotificationStrategy

class NotificationRouter(
    private val services: List<NotificationStrategy>
) {

    suspend fun route(notification: Notification, allowedChannels: Set<NotificationChannel>) {
        val channels = notification.channels.filter { it in allowedChannels }

        channels.forEach { currentChannel ->
            val sender = services.firstOrNull { it.supports(currentChannel) }
            sender?.let {
                runCatching {
                    it.sendNotification(notification)
                }.onFailure {
                    println("Error sending notification: ${it.message} via channel ${currentChannel.name}")
                }
            }
        }

    }

}