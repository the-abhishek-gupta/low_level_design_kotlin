package message_broker

class PubSubMain {
    fun main() {
        val broker = MessageBroker()
        broker.createTopic("Orders")
        broker.createTopic("Payments")

        val consumer1 = PrintConsumer("C1")
        val consumer2 = PrintConsumer("C2")

        broker.subsribe("Orders", consumer1)
        broker.subsribe("Payments", consumer1)
        broker.subsribe("Orders", consumer2)

        val producer = Producer(broker)

        producer.publish(
            "Orders",
            payload = "Order #1 is ready",
        )
        producer.publish(
            "Payments",
            payload = "Payment is completed",
        )
        producer.publish(
            "Orders",
            payload = "Order #2 is ready",
        )
        println("Order history for Orders : ${broker.getMessagesForTopic("Orders")}")
    }
}