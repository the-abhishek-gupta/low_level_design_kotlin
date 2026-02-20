package parkinglot.model.ticket

import parkinglot.model.parking.ParkingSpot
import parkinglot.model.vehicle.Vehicle

data class Ticket(
    val ticketId: String,
    val vehicle: Vehicle,
    val parkingSpot: ParkingSpot,
    val entryTime: Long = System.currentTimeMillis()
)
