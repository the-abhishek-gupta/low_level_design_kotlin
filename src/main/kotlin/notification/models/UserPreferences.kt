package org.example.notification.models

import org.example.notification.enums.NotificationChannel

data class UserPreferences(val userId: String, val enabledChannels: Set<NotificationChannel>)
