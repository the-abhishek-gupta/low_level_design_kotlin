package ecommerce.models.order

import ecommerce.models.User
import java.util.UUID

data class Order(
    private val id: String = UUID.randomUUID().toString(),
    val user : User,
    val items: List<OrderItem>,
    val amount: Double,
    var status: OrderStatus = OrderStatus.CREATED,
){

    fun getOrderId() = id
}