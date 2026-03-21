package flight_aggregator_system

import flight_aggregator_system.flight_provider.FlightProvider

data class FlightInfo(
    val flightNumber: String,
    val airline: String,
    val source: String,
    val destination: String,
    val departureTime: String,
    val arrivalTime: String,
    val durationMinutes: Int,
    val price: Double,
    val stops: Int,
    val provider: String
)