package message_broker

class MessageBroker {

    private val topics = mutableMapOf<String, Topic>()

    @Synchronized
    fun createTopic(topicName: String) {
        topics.putIfAbsent(topicName, Topic(topicName))
    }

    @Synchronized
    fun subsribe(topicName: String, consumer: Consumer) {
        val topic = topics[topicName] ?: throw IllegalArgumentException("Topic ${topicName} not found")
        topic.addSubscriber(consumer)
    }

    fun unsubscribe(topicName: String, consumer: Consumer) {
        val topic = topics[topicName] ?: throw IllegalArgumentException("Topic ${topicName} not found")
        topic.removeSubscriber(consumer)
    }

    @Synchronized
    fun publishMessage(topicName: String, message: Message) {
        val topic = topics[topicName] ?: throw IllegalArgumentException("Topic ${topicName} not found")
        topic.publish(message)
    }

    fun getMessagesForTopic(topicName: String): List<Message> {
        val topic = topics[topicName] ?: throw IllegalArgumentException("Topic ${topicName} not found")
        return topic.getMessages()
    }

}