package parkinglot.data.index

import VehicleType
import parkinglot.model.parking.ParkingSpot
import java.util.*

class SpotIndex {

    private val freeSpots = mutableMapOf<VehicleType, PriorityQueue<ParkingSpot>>()

    fun getSpot(vehicleType: VehicleType): ParkingSpot? {
        return freeSpots[vehicleType]?.poll()
    }

    fun addSpot(parkingSpot: ParkingSpot) {
        freeSpots.computeIfAbsent(parkingSpot.vehicleType) { PriorityQueue(compareBy { it.id }) }.add(parkingSpot)
    }


    fun releaseSpot(parkingSpot: ParkingSpot) {
        addSpot(parkingSpot)
    }
}