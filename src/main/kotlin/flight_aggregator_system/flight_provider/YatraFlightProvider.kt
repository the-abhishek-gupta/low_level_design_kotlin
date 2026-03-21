package flight_aggregator_system.flight_provider

import flight_aggregator_system.FlightInfo
import flight_aggregator_system.FlightSearchRequest

class YatraFlightProvider() : FlightProvider {
    override fun searchFlights(request: FlightSearchRequest): List<FlightInfo> {
        return listOf(
            FlightInfo(
                flightNumber = "AI202",
                airline = "Air India",
                source = request.source,
                destination = request.destination,
                departureTime = "${request.departureDate}T09:00",
                arrivalTime = "${request.departureDate}T12:00",
                durationMinutes = 180,
                price = 4900.0,
                stops = 1,
                provider = getName()
            )
        )
    }

    override fun getName(): String {
        return "Yatra"
    }
}