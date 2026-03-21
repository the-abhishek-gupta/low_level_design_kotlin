package event_logging_library.service

import kotlinx.coroutines.supervisorScope
import event_logging_library.model.Event
import event_logging_library.model.ScreenEvent
import event_logging_library.model.UserProperty
import event_logging_library.strategy.AnalyticsProvider

class EventDispatcher(
    private val providers: List<AnalyticsProvider>
) {
    suspend fun dispatchEvent(event: Event) = supervisorScope {
        providers.forEach { provider ->
            runCatching {
                provider.logEvent(event)
            }.onFailure {
                println("Provider Error in dispatching event: ${event.eventName} ${it.message}")
            }
        }
    }

    suspend fun dispatchScreen(screenEvent: ScreenEvent) {
        providers.forEach { provider ->
            runCatching {
                provider.logScreen(screenEvent)
            }.onFailure {
                println("Provider failed for screen :${screenEvent.screenName} ${it.message}")
            }
        }
    }

    suspend fun dispatchUserProperty(userProperty: UserProperty) {
        providers.forEach { provider ->
            runCatching {
                provider.setUserProperty(userProperty)
            }.onFailure {
                println("Provider failed for user property :${userProperty.key} ${it.message}")
            }
        }

    }

    suspend fun dispatchUserId(userId: String?) {
        providers.forEach { provider ->
            runCatching {
                provider.setUserId(userId)
            }.onFailure {
                println("Provider failed for user property :${userId} ${it.message}")
            }
        }
    }

    suspend fun flush() {
        providers.forEach { provider ->
            runCatching {
                provider.flush()
            }.onFailure {
                println("Provider flush failed")
            }
        }
    }

}