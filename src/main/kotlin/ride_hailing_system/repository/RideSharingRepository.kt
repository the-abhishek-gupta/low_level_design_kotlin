package ride_hailing_system.repository

import ride_hailing_system.models.Driver
import ride_hailing_system.models.RHSLocation
import ride_hailing_system.models.Ride
import ride_hailing_system.models.Rider
import ride_hailing_system.models.enums.RideStatus

interface RideSharingRepository {
    fun addRider(rider: Rider): Boolean

    fun addDriver(driver: Driver)

    fun requestRide(rider: Rider, source: RHSLocation, destination: RHSLocation): Ride?

    fun updateRide(ride: Ride, rideStatus: RideStatus)

    fun getAvailableDrivers(): List<Driver>

    fun updateDriverData(driver: Driver, location: RHSLocation? , isAvailable: Boolean?)
}