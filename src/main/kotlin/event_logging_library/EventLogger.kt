package org.example.event_logging_library

import org.example.event_logging_library.model.Event
import org.example.event_logging_library.model.ScreenEvent
import org.example.event_logging_library.model.UserProperty

interface EventLogger {
    fun log(event: Event)
    fun logScreen(screenEvent: ScreenEvent)
    fun setUserProperty(userProperty: UserProperty)
    fun setUserId(userId: String?)
    fun flush()
}