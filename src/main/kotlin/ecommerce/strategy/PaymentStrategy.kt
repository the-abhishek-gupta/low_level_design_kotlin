package ecommerce.strategy

import ecommerce.models.CartItem

interface PaymentStrategy {
    fun calculateTotal(list: List<CartItem>): Double
}

class PaymentStrategyImpl : PaymentStrategy {
    override fun calculateTotal(list: List<CartItem>): Double {
        return list.sumOf { it.quantity * it.item.price }
    }
}