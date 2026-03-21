package notification.strategy.user_preference_strategy

import notification.enums.NotificationChannel
import notification.models.UserPreferences

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