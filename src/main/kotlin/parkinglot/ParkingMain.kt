package parkinglot

import VehicleType
import parkinglot.data.index.SpotIndex
import parkinglot.model.parking.ParkingFloor
import parkinglot.model.parking.ParkingLot
import parkinglot.model.parking.ParkingSpot
import parkinglot.model.vehicle.Car
import parkinglot.strategy.allocationStrategy.DefaultAllocationStrategy
import parkinglot.strategy.pricing.FlatFirstTwoHoursRule
import parkinglot.strategy.pricing.HourlyRule

class ParkingMain {

    fun main(args: Array<String>) {
        val spots = listOf(
            ParkingSpot("S1", VehicleType.BIKE),
            ParkingSpot("S2", VehicleType.CAR),
            ParkingSpot("S3", VehicleType.TRUCK),
        )
        val floor = ParkingFloor(1, spots)
        val parkingLot = ParkingLot(listOf(floor))

        val spotIndex = SpotIndex()
        spots.forEach {
            spotIndex.addSpot(it)
        }

        val allocationStrategy = DefaultAllocationStrategy(spotIndex)

        val pricingEngine = PricingEngine(
            listOf(
                FlatFirstTwoHoursRule(), HourlyRule(50.0)
            )
        )

        val parkingManager = ParkingManager(allocationStrategy, pricingEngine, spotIndex)

        val car = Car("HR98W1118")
        val ticket = parkingManager.park(car)
        println(ticket)
        Thread.sleep(1000)
        val fee = parkingManager.exit(ticket!!.ticketId)
        println(fee)
    }
}