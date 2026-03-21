package notification.models

import notification.enums.NotificationChannel

data class UserPreferences(val userId: String, val enabledChannels: Set<NotificationChannel>)
