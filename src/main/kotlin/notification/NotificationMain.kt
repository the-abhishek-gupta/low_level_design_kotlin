package notification

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import notification.enums.NotificationChannel
import notification.models.Notification
import notification.service.NotificationRouter
import notification.service.RetryService
import notification.strategy.notification_strategy.EmailNotificationService
import notification.strategy.notification_strategy.PushNotificationService
import notification.strategy.notification_strategy.SMSNotificationService
import notification.strategy.user_preference_strategy.DefaultUserPreference

class NotificationMain {
    fun main() = runBlocking {
        val notificationServices = listOf(
            SMSNotificationService(),
            PushNotificationService(),
            EmailNotificationService()
        )

        val router = NotificationRouter(notificationServices)

        val preferenceService = DefaultUserPreference()

        val retryService = RetryService()

        val manager = NotificationManager(
            router = router,
            preferenceService = preferenceService,
            retryService = retryService,
        )

        val notification = Notification(
            recipientId = "abhi123",
            title = "Item arrived", message = "Your item has arrived", channels = listOf(NotificationChannel.PUSH)
        )
        manager.sendNotification(notification)

        delay(1000)
    }
}