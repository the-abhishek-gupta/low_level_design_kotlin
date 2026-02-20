package parkinglot.strategy.allocationStrategy

import parkinglot.model.parking.ParkingSpot
import parkinglot.model.vehicle.Vehicle

interface AllocationStrategy {
    fun allocate(vehicle : Vehicle) : ParkingSpot?
}