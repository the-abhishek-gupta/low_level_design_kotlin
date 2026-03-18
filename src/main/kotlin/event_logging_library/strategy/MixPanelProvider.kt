package org.example.event_logging_library.strategy

import org.example.event_logging_library.model.Event
import org.example.event_logging_library.model.ScreenEvent
import org.example.event_logging_library.model.UserProperty

class MixPanelProvider : AnalyticsProvider {
    override suspend fun logEvent(event: Event) {
        println("Logging from Mixpanel ${event.eventName}  ${event.parameters} ")
    }

    override suspend fun logScreen(screen: ScreenEvent) {
        println("Mixpanel -> Screen $screen")
    }

    override suspend fun setUserProperty(userProperty: UserProperty) {
        println("Mixpanel -> UserProperty: ${userProperty.key}=${userProperty.value}")
    }

    override suspend fun setUserId(id: String?) {
        println("Mixpanel -> UserId: $id")
    }

    override suspend fun flush() {
        println("Mixpanel -> flush")
    }
}