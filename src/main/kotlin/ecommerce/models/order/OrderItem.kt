package ecommerce.models.order

import ecommerce.models.Product

data class OrderItem(
    val product: Product,
    val quantity: Int,
    val price: Double
)