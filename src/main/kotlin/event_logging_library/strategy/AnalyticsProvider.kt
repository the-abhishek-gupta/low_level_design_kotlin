package org.example.event_logging_library.strategy

import org.example.event_logging_library.model.Event
import org.example.event_logging_library.model.ScreenEvent
import org.example.event_logging_library.model.UserProperty

interface AnalyticsProvider {
    suspend fun logEvent(event: Event)
    suspend fun logScreen(screen: ScreenEvent)
    suspend fun setUserProperty(userProperty: UserProperty)
    suspend fun setUserId(id: String?)
    suspend fun flush()
}