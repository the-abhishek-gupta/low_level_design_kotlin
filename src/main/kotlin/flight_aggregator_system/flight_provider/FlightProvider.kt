package flight_aggregator_system.flight_provider

import flight_aggregator_system.FlightInfo
import flight_aggregator_system.FlightSearchRequest

interface FlightProvider {

    fun searchFlights(request: FlightSearchRequest): List<FlightInfo>

    fun getName(): String
}