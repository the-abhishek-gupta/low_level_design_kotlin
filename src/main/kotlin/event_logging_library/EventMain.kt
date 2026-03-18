package org.example.event_logging_library

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import org.example.event_logging_library.model.Event
import org.example.event_logging_library.model.ScreenEvent
import org.example.event_logging_library.model.UserProperty
import org.example.event_logging_library.service.EventDispatcher
import org.example.event_logging_library.service.EventLoggerImpl
import org.example.event_logging_library.strategy.AnalyticsProvider
import org.example.event_logging_library.strategy.FirebaseProvider
import org.example.event_logging_library.strategy.MixPanelProvider

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