package ride_hailing_system.strategy.driver_matching

import ride_hailing_system.models.Driver
import ride_hailing_system.models.RHSLocation
import ride_hailing_system.models.Rider

interface DriverMatchingStrategy {
    fun assignDriver(source: RHSLocation, drivers: List<Driver>) : Driver?
}