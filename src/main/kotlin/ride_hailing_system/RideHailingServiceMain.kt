package ride_hailing_system

import ride_hailing_system.models.RHSLocation
import ride_hailing_system.service.RideSharingService

class RideHailingServiceMain {
    fun main() {
        val rideHailingService = RideSharingService()

        val rider = rideHailingService.addRider("R1")
        val driver1 = rideHailingService.addDriver("D1")
        val driver2 = rideHailingService.addDriver("D2")
        val driver3 = rideHailingService.addDriver("D3")

        rideHailingService.updateDriverData(driver1, RHSLocation(5.5, 6.0))
        rideHailingService.updateDriverData(driver2, RHSLocation(0.5, 5.0))
        rideHailingService.updateDriverData(driver3, RHSLocation(4.5, 5.0))

        println("Available drivers ${rideHailingService.getAvailableDrivers()}")

        val ride1 = rideHailingService.requestRide(
            rider,
            source = RHSLocation(1.0, 6.0),
            destination = RHSLocation(5.0, 4.0),
        )
        rideHailingService.cancelRide(ride1)


        val ride2 = rideHailingService.requestRide(
            rider,
            source = RHSLocation(1.0, 6.0),
            destination = RHSLocation(5.0, 4.0),
        )
        rideHailingService.startRide(ride2)
        println("Ride details ${ride2}")
        println("Available drivers ${rideHailingService.getAvailableDrivers()}")
        rideHailingService.completeRide(ride2)

        println("Available drivers ${rideHailingService.getAvailableDrivers()}")

    }
}