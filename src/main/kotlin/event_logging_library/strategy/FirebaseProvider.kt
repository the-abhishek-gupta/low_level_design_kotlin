package event_logging_library.strategy

import event_logging_library.model.Event
import event_logging_library.model.ScreenEvent
import event_logging_library.model.UserProperty

class FirebaseProvider : AnalyticsProvider {
    override suspend fun logEvent(event: Event) {
        println("Logging from Firebase Provider: ${event.eventName} ${event.parameters} ")
    }

    override suspend fun logScreen(screen: ScreenEvent) {
        println("Logging from Firebase Provider: ${screen.screenName} ")
    }

    override suspend fun setUserProperty(userProperty: UserProperty) {
        println("Firebase -> UserProperty: ${userProperty.key}=${userProperty.value}")
    }

    override suspend fun setUserId(id: String?) {
        println("Firebase -> UserId: $id")
    }

    override suspend fun flush() {
        println("Firebase -> Flush")
    }
}