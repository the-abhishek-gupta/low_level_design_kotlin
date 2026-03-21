package message_broker

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class Topic(val topicName: String, val scope: CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)) {
    private val subscribers = mutableListOf<Consumer>()
    private val messages = mutableListOf<Message>()

    fun addMessage(message: Message) {
        messages.add(message)
    }

    fun addSubscriber(consumer: Consumer) {
        subscribers.add(consumer)
    }

    fun removeSubscriber(consumer: Consumer) {
        subscribers.remove(consumer)
    }

    fun publish(message: Message) {
        messages.add(message)
        scope.launch {
            subscribers.forEach { subscriber ->
                scope.launch {
                    runCatching {
                        subscriber.consume(message, topicName)
                    }.onFailure {
                        println("$subscriber failed: ${it.message}")
                    }
                }
            }
        }

    }

    fun getMessages(): List<Message> = messages.toList()

}