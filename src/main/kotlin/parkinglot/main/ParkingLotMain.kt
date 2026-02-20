package parkinglot.main

import VehicleType
import parkinglot.ParkingManager
import parkinglot.PricingEngine
import parkinglot.data.index.SpotIndex
import parkinglot.model.parking.ParkingFloor
import parkinglot.model.parking.ParkingLot
import parkinglot.model.parking.ParkingSpot
import parkinglot.model.vehicle.Car
import parkinglot.strategy.allocationStrategy.DefaultAllocationStrategy
import parkinglot.strategy.pricing.FlatFirstTwoHoursRule
import parkinglot.strategy.pricing.HourlyRule

class ParkingLotMain {

    fun main() {

        val spots = listOf(
            ParkingSpot("S1", VehicleType.CAR),
            ParkingSpot("S2",VehicleType.CAR),
            ParkingSpot("S3",VehicleType.CAR)
        )

        val floor = ParkingFloor(1, spots)
        val lot = ParkingLot(listOf(floor))

        val spotIndex = SpotIndex()
        spots.forEach { spotIndex.addSpot(it) }

        val allocation = DefaultAllocationStrategy(spotIndex)

        val pricingEngine = PricingEngine(
            listOf(
                FlatFirstTwoHoursRule(),
                HourlyRule(50.0)
            )
        )

        val manager = ParkingManager(
            allocation,
            pricingEngine,
            spotIndex
        )

        val car = Car("HR98L5730")

        val ticket = manager.park(car)
        println(ticket)

        Thread.sleep(1000)

        val fee = manager.exit(ticket!!.ticketId)
        println("Fee = $fee")
    }

}