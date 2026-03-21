package event_logging_library

import event_logging_library.model.Event
import event_logging_library.model.ScreenEvent
import event_logging_library.model.UserProperty

interface EventLogger {
    fun log(event: Event)
    fun logScreen(screenEvent: ScreenEvent)
    fun setUserProperty(userProperty: UserProperty)
    fun setUserId(userId: String?)
    fun flush()
}