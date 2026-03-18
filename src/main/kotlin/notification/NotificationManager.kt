package org.example.notification

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.example.notification.models.Notification
import org.example.notification.service.NotificationRouter
import org.example.notification.service.RetryService
import org.example.notification.strategy.user_preference_strategy.UserPreferenceStrategy

class NotificationManager(
    private val router: NotificationRouter,
    private val preferenceService: UserPreferenceStrategy,
    private val retryService: RetryService,
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

) {
    fun sendNotification(notification: Notification) {
        scope.launch {
            val allowedChannels = preferenceService.getPreference(notification.id)
            retryService.performRetry {
                router.route(notification = notification, allowedChannels = allowedChannels.enabledChannels)
            }
        }
    }
}