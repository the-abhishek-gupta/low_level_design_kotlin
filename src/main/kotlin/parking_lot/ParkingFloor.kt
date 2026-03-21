package parking_lot

class ParkingFloor(private val floorId: String, val parkingSpots: List<ParkingSpot>) {

    fun findAvailableSpot(): ParkingSpot? {
        return parkingSpots.firstOrNull()
    }

    fun getAvailableSpotsCount(): Int {
        return parkingSpots.count { it.isAvailable() }
    }

}