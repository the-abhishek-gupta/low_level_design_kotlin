package flight_aggregator_system.flight_provider

import flight_aggregator_system.FlightInfo
import flight_aggregator_system.FlightSearchRequest

class MMTFlightProvider() : FlightProvider {
    override fun searchFlights(request: FlightSearchRequest): List<FlightInfo> {
        return listOf(
            FlightInfo(
                flightNumber = "6E101",
                airline = "IndiGo",
                source = request.source,
                destination = request.destination,
                departureTime = "${request.departureDate}T08:00",
                arrivalTime = "${request.departureDate}T10:30",
                durationMinutes = 150,
                price = 5200.0,
                stops = 0,
                provider = getName()
            )
        )
    }

    override fun getName(): String {
        return "MakeMyTrip"
    }
}