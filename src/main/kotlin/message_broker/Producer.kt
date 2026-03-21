package message_broker

class Producer(val broker: MessageBroker) {
    fun publish(topicName: String, payload: String) {
        broker.publishMessage(topicName, Message(payload = payload))
    }
}