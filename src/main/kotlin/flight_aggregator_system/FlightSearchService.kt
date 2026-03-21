package flight_aggregator_system

import flight_aggregator_system.flight_provider.FlightProvider

class FlightSearchService(val providers: List<FlightProvider>) {

    fun search(request: FlightSearchRequest): List<FlightInfo> {

        val flightsList = mutableListOf<FlightInfo>()
        providers.forEach { provider ->
            val flights = try {
                provider.searchFlights(request)
            } catch (e: Exception) {
                emptyList()
            }
            flightsList.addAll(flights)
        }
        return flightsList
    }
}