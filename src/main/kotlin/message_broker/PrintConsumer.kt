package message_broker

class PrintConsumer(private val name : String) : Consumer {
    override fun consume(message: Message, topic: String) {
        println("$name is consuming $message for topic $topic")
    }
}