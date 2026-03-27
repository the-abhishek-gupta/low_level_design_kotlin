package ride_hailing_system.strategy.fare_calculation

import ride_hailing_system.models.RHSLocation

interface FareCalculationStrategy {
    fun calculatePrice(source: RHSLocation, destination: RHSLocation): Double
}