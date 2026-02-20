package parkinglot.model.parking

import VehicleType

open class ParkingSpot(val id : String, val vehicleType: VehicleType){
    var isOccupied = false
}