package bookmyshow.pricing_strategy

import bookmyshow.Seat
import bookmyshow.SeatType

class DefaultPricingStrategy : PricingStrategy {
    override fun calculatePrice(seats: List<Seat>): Double {
        var price = 0.0
        seats.forEach { seat ->
            price += getPrice(seat.type)
        }
        return price
    }

    private fun getPrice(type: SeatType): Double {
        return when (type) {
            SeatType.SILVER -> 250.0
            SeatType.GOLD -> 300.0
            SeatType.PLATINUM -> 500.0
        }
    }
}