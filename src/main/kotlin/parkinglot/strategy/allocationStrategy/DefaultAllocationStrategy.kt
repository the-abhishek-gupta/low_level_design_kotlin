package parkinglot.strategy.allocationStrategy

import parkinglot.data.index.SpotIndex
import parkinglot.model.parking.ParkingSpot
import parkinglot.model.vehicle.Vehicle

class DefaultAllocationStrategy(val spotIndex: SpotIndex) : AllocationStrategy {
    override fun allocate(vehicle: Vehicle): ParkingSpot? {
        return spotIndex.getSpot(vehicle.vehicleType)
    }
}