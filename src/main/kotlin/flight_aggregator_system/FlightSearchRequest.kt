package flight_aggregator_system

data class FlightSearchRequest(
    val source: String,
    val destination: String,
    val departureDate : String,
    val noOfPassengers: Int,
    val cabinClass : CabinClass
)
