package message_broker

import java.util.UUID

data class Message(
    private val id: String = UUID.randomUUID().toString(),
    val payload: String,
    private val timestamp: Long = System.currentTimeMillis()
)