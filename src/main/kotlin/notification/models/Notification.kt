package org.example.notification.models

import org.example.notification.enums.NotificationChannel
import java.util.UUID

data class Notification(
    private val id: String = UUID.randomUUID().toString(),
    val recipientId: String,
    val title: String,
    val message: String,
    val channels: List<NotificationChannel>,
    val metadata: Map<String, Any?> = emptyMap()
)