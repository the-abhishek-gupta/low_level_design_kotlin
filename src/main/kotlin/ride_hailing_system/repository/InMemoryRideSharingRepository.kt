package ride_hailing_system.repository

import ride_hailing_system.models.Driver
import ride_hailing_system.models.RHSLocation
import ride_hailing_system.models.Ride
import ride_hailing_system.models.Rider
import ride_hailing_system.models.enums.RideStatus
import ride_hailing_system.strategy.driver_matching.DriverMatchingStrategy
import ride_hailing_system.strategy.driver_matching.NearestDriverMatchingStrategy
import ride_hailing_system.strategy.fare_calculation.DefaultFareCalculationStrategy
import ride_hailing_system.strategy.fare_calculation.FareCalculationStrategy

class InMemoryRideSharingRepository(
    val driverMatchingStrategy: DriverMatchingStrategy = NearestDriverMatchingStrategy(),
    val fareCalculationStrategy: FareCalculationStrategy = DefaultFareCalculationStrategy()
) :
    RideSharingRepository {


    val ridersMap = mutableMapOf<String, Rider>()
    val driversMap = mutableMapOf<String, Driver>()
    val ridesMap = mutableMapOf<String, Ride>()

    override fun addRider(rider: Rider): Boolean {
        if (ridersMap.containsKey(rider.getId()))
            return false
        ridersMap[rider.getId()] = rider
        return true
    }

    override fun addDriver(driver: Driver) {
        driversMap[driver.name] = driver
    }

    override fun requestRide(rider: Rider, source: RHSLocation, destination: RHSLocation): Ride? {
        val assignedDriver = driverMatchingStrategy.assignDriver(source, driversMap.values.toList()) ?: return null
        updateDriverData(
            driver = assignedDriver, isAvailable = false,
            location = null
        )
        val calculatedFare = fareCalculationStrategy.calculatePrice(source, destination)
        val currentRide = Ride(rider, assignedDriver, source, destination, calculatedFare)
        ridesMap[currentRide.getRideId()] = currentRide
        return currentRide

    }

    override fun updateRide(ride: Ride, rideStatus: RideStatus) {
        ridesMap[ride.getRideId()]?.status = rideStatus
    }

    override fun getAvailableDrivers(): List<Driver> {
        return driversMap.values.filter { it.isAvailable }.toList()
    }

    override fun updateDriverData(
        driver: Driver,
        location: RHSLocation?,
        isAvailable: Boolean?
    ) {
        println("Updating driver ${driver.getId()} location $location isAvailable $isAvailable")
        if (location != null) {
            driversMap[driver.getId()]?.currentLocation = location
        }
        if (isAvailable != null) {
            driversMap[driver.getId()]?.isAvailable = isAvailable
        }
    }
}