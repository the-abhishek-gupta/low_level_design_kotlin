package bookmyshow.pricing_strategy

import bookmyshow.Seat

interface PricingStrategy {
    fun calculatePrice(seats: List<Seat>): Double
}