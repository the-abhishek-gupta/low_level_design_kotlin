package org.example.notification.service.user_preference

import org.example.notification.enums.NotificationChannel
import org.example.notification.models.UserPreferences
import org.example.notification.strategy.user_preference_strategy.UserPreferenceStrategy

class DefaultUserPreference : UserPreferenceStrategy {
    override fun getPreference(id: String): UserPreferences {
        return UserPreferences(
            userId = id,
            enabledChannels = setOf(
                NotificationChannel.EMAIL,
                NotificationChannel.SMS
            )
        )
    }
}