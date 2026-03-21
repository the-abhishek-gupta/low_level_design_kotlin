package message_broker

interface Consumer {
    fun consume(message: Message, topic: String)
}