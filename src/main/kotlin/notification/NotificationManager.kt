package notification

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import notification.models.Notification
import notification.service.NotificationRouter
import notification.service.RetryService
import notification.strategy.user_preference_strategy.UserPreferenceStrategy

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