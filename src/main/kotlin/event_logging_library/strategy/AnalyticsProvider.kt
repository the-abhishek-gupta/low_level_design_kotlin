package event_logging_library.strategy

import event_logging_library.model.Event
import event_logging_library.model.ScreenEvent
import event_logging_library.model.UserProperty

interface AnalyticsProvider {
    suspend fun logEvent(event: Event)
    suspend fun logScreen(screen: ScreenEvent)
    suspend fun setUserProperty(userProperty: UserProperty)
    suspend fun setUserId(id: String?)
    suspend fun flush()
}