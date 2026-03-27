package ride_hailing_system.models

import ride_hailing_system.models.enums.RideStatus
import java.util.UUID

data class Ride(
    val rider: Rider,
    val driver: Driver,
    val rideSource: RHSLocation,
    val rideDestination: RHSLocation,
    var fare: Double = -1.0
) {

    private val id: String = UUID.randomUUID().toString()
    fun getRideId(): String = id

    var status: RideStatus = RideStatus.RIDE_REQUESTED
}
