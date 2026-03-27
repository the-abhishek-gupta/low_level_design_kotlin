package ride_hailing_system.strategy.driver_matching

import ride_hailing_system.models.Driver
import ride_hailing_system.models.RHSLocation

class NearestDriverMatchingStrategy : DriverMatchingStrategy {
    override fun assignDriver(
        source: RHSLocation,
        drivers: List<Driver>
    ): Driver? {
        return drivers.filter { it.isAvailable }.minByOrNull { driver ->
            driver.currentLocation!!.calculateDistance(source)
        }
    }
}