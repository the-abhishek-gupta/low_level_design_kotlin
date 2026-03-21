package parking_lot

import java.util.UUID

data class ParkingTicket(
    private val id: String = UUID.randomUUID().toString(),
    val vehicle: Vehicle,
    val parkingSpot: ParkingSpot,
    val entryTime: Long = System.currentTimeMillis(),
) {
    fun getTicket() = id
}