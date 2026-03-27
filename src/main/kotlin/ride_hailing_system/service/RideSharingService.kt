package ride_hailing_system.service

import ride_hailing_system.models.Driver
import ride_hailing_system.models.RHSLocation
import ride_hailing_system.models.Ride
import ride_hailing_system.models.Rider
import ride_hailing_system.models.enums.RideStatus
import ride_hailing_system.repository.InMemoryRideSharingRepository
import ride_hailing_system.repository.RideSharingRepository

class RideSharingService(val repo: RideSharingRepository = InMemoryRideSharingRepository()) {
    fun addRider(name: String): Rider {
        val rider = Rider(name = name)
        repo.addRider(rider)
        return rider
    }

    fun addDriver(driverName: String): Driver {
        val driver = Driver(id = driverName, name = driverName)
        repo.addDriver(driver)
        return driver
    }

    fun updateDriverData(driver: Driver, location: RHSLocation) {
        repo.updateDriverData(
            driver, location, null
        )
    }

    fun requestRide(rider: Rider, source: RHSLocation, destination: RHSLocation): Ride {
        val ride = repo.requestRide(rider, source, destination) ?: throw Exception("No ride found")
        return ride
    }

    fun startRide(ride: Ride) {
        repo.updateRide(ride, RideStatus.RIDE_IN_PROGRESS)
    }

    fun completeRide(ride: Ride) {
        repo.updateRide(ride, RideStatus.RIDE_COMPLETED)
        repo.updateDriverData(ride.driver, ride.rideDestination, true)
    }


    fun cancelRide(ride: Ride) {
        repo.updateRide(ride, RideStatus.RIDE_CANCELLED)
        repo.updateDriverData(ride.driver, ride.rideDestination, true)
    }

    fun getAvailableDrivers(): List<Driver> {
        return repo.getAvailableDrivers()
    }
}