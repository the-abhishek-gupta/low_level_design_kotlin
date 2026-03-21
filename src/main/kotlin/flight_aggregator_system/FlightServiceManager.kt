package flight_aggregator_system

import flight_aggregator_system.flight_provider.MMTFlightProvider
import flight_aggregator_system.flight_provider.YatraFlightProvider

class FlightServiceManager {
    fun main() {
        val providers = listOf(MMTFlightProvider(), YatraFlightProvider())
        val service = FlightSearchService(providers)

        val request = FlightSearchRequest(
            source = "DEL",
            destination = "BLR",
            departureDate = "2026-03-25",
            noOfPassengers = 1,
            cabinClass = CabinClass.ECONOMY,
        )

        val results = service.search(request)

        results.forEach {
            println(it)
        }
    }
}