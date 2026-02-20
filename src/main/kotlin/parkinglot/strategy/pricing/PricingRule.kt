package parkinglot.strategy.pricing

import parkinglot.model.ticket.Ticket

interface PricingRule {
    fun apply(ticket : Ticket, currentAmount : Double) : Double
}