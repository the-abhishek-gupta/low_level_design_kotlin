package parking_lot

class ParkingLotManager(private val floors: List<ParkingFloor>) {
    private val ticketsMap = mutableMapOf<String, ParkingTicket>()

    fun parkVehicle(vehicle: Vehicle): ParkingTicket? {
        for (floor in floors) {
            val spot = floor.findAvailableSpot() ?: continue
            spot.park(vehicle = vehicle)
            val ticket = ParkingTicket(vehicle = vehicle, parkingSpot = spot)
            ticketsMap[ticket.getTicket()] = ticket
            return ticket
        }
        println("No available parking spot")
        return null
    }

    fun unparkVehicle(ticket: String): Vehicle? {
        val ticket = ticketsMap[ticket]
        if (ticket == null) {
            println("Invalid ticket $ticket")
            return null
        }

        val spot = ticket.parkingSpot
        val vehicle = spot.unpark() ?: return null
        println("Unparked vehicle $vehicle")
        return vehicle

    }
}