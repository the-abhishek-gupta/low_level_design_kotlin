package parkinglot.model.parking

import parkinglot.enums.VehicleType

open class ParkingSpot(val id : String, val vehicleType: VehicleType){
    var isOccupied = false
}