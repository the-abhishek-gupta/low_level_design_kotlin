package event_logging_library.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import event_logging_library.EventLogger
import event_logging_library.model.Event
import event_logging_library.model.ScreenEvent
import event_logging_library.model.UserProperty

class EventLoggerImpl(
    val dispatcher: EventDispatcher,
    val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
) : EventLogger {
    override fun log(event: Event) {
        scope.launch {
            dispatcher.dispatchEvent(event = event)
        }

    }

    override fun logScreen(screenEvent: ScreenEvent) {
        scope.launch {
            dispatcher.dispatchScreen(screenEvent)
        }
    }

    override fun setUserProperty(userProperty: UserProperty) {
        scope.launch {
            dispatcher.dispatchUserProperty(userProperty)
        }
    }

    override fun setUserId(userId: String?) {
        scope.launch {
            dispatcher.dispatchUserId(userId)
        }
    }


    override fun flush() {
        scope.launch {
            dispatcher.flush()
        }
    }
}