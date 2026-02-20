package parkinglot.strategy.pricing

import parkinglot.model.ticket.Ticket

class HourlyRule(val rate : Double): PricingRule {
    override fun apply(ticket: Ticket, currentAmount: Double): Double {
        val hoursParked = countHours(ticket.entryTime)
        return currentAmount + hoursParked * rate
    }

    private fun countHours(entryTime: Long): Long {
        return (System.currentTimeMillis() - entryTime) / 3600000
    }
}