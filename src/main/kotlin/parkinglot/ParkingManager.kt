package parkinglot

import parkinglot.data.index.SpotIndex
import parkinglot.model.ticket.Ticket
import parkinglot.model.vehicle.Vehicle
import parkinglot.strategy.allocationStrategy.AllocationStrategy

class ParkingManager(
    private val allocationStrategy: AllocationStrategy,
    private val pricingEngine: PricingEngine,
    private val spotIndex: SpotIndex
) {
    private val activeTickets = mutableMapOf<String, Ticket>()

    fun park(vehicle: Vehicle): Ticket? {
        val spot = allocationStrategy.allocate(vehicle) ?: return null
        spot.isOccupied = true
        val ticket = Ticket(ticketId = "T-${System.nanoTime()}", parkingSpot = spot, vehicle = vehicle)
        activeTickets[ticket.ticketId] = ticket
        return ticket
    }

    fun exit(ticketId: String) : Double{
        val ticket = activeTickets.remove(ticketId) ?: throw Exception("Invalid ticket")
        val fee = pricingEngine.calculate(ticket)
        ticket.parkingSpot.isOccupied = false
        spotIndex.releaseSpot(ticket.parkingSpot)
        return fee
    }
}