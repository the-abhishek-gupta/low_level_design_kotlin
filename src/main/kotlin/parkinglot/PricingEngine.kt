package parkinglot

import parkinglot.model.ticket.Ticket
import parkinglot.strategy.pricing.PricingRule

class PricingEngine(val rules : List<PricingRule>) {
    fun calculate(ticket: Ticket): Double{
        var amount = 0.0
        rules.forEach{
            amount = it.apply(ticket, amount)
        }
        return amount
    }
}