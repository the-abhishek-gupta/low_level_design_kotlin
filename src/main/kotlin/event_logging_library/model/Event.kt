package org.example.event_logging_library.model

data class Event(
    val eventName: String,
    val parameters: Map<String, Any?> = emptyMap(),
    val timestamp: Long = System.currentTimeMillis()
)