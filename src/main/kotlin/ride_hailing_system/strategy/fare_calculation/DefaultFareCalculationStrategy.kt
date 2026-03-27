package ride_hailing_system.strategy.fare_calculation

import ride_hailing_system.models.RHSLocation

class DefaultFareCalculationStrategy : FareCalculationStrategy {

    val perUnitDistanceFare = 10.0
    val baseFare = 50.0
    override fun calculatePrice(
        source: RHSLocation,
        destination: RHSLocation
    ): Double {
        val distance = source.calculateDistance(destination)
        return distance * perUnitDistanceFare + baseFare
    }
}