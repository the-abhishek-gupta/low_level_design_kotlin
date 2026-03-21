package parking_lot

import parkinglot.enums.VehicleType

class ParkingSpot(private val id: String, val type: VehicleType) {

    var parkedVehicle: Vehicle? = null
    fun isAvailable(): Boolean = parkedVehicle == null

    fun park(vehicle: Vehicle): Boolean {
        if (!isAvailable())
            return false
        parkedVehicle = vehicle
        return true
    }

    fun unpark(): Vehicle? {
        val vehicle = parkedVehicle
        parkedVehicle = null
        return vehicle
    }
}
