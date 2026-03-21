package event_logging_library

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import event_logging_library.model.Event
import event_logging_library.model.ScreenEvent
import event_logging_library.model.UserProperty
import event_logging_library.service.EventDispatcher
import event_logging_library.service.EventLoggerImpl
import event_logging_library.strategy.AnalyticsProvider
import event_logging_library.strategy.FirebaseProvider
import event_logging_library.strategy.MixPanelProvider

class EventMain {
    fun main() = runBlocking {
        val listOfProviders = listOf<AnalyticsProvider>(FirebaseProvider(), MixPanelProvider())

        val logger = EventLoggerImpl(EventDispatcher(listOfProviders))

        logger.setUserId("abc123")
        logger.setUserProperty(UserProperty("plan", "premium"))

        logger.log(Event("Product Clicked", mapOf("productId" to 123)))

        logger.logScreen(ScreenEvent("HomeScreen"))

        logger.flush()
        delay(1000)

    }
}