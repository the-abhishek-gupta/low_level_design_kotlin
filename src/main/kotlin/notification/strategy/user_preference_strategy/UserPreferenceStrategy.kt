package notification.strategy.user_preference_strategy

import notification.models.UserPreferences

interface UserPreferenceStrategy{
    fun getPreference(id: String) : UserPreferences
}