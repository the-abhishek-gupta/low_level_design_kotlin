package parkinglot.strategy.pricing

import parkinglot.model.ticket.Ticket

class FlatFirstTwoHoursRule : PricingRule {
    override fun apply(ticket: Ticket, currentAmount: Double): Double {
        val hoursParked = countHours(ticket.entryTime)
        return if (hoursParked <= 2.0)100.0 else currentAmount
    }

    private fun countHours(entryTime: Long): Long {
        return (System.currentTimeMillis() - entryTime) / 3600000
    }
}