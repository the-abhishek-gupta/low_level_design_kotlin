package org.example.notification.strategy.user_preference_strategy

import org.example.notification.models.UserPreferences

interface UserPreferenceStrategy{
    fun getPreference(id: String) : UserPreferences
}