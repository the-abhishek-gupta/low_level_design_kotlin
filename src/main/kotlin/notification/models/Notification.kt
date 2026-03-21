package notification.models

import notification.enums.NotificationChannel
import java.util.UUID

data class Notification(
    val id: String = UUID.randomUUID().toString(),
    val recipientId: String,
    val title: String,
    val message: String,
    val channels: List<NotificationChannel>,
    val metadata: Map<String, Any?> = emptyMap()
)