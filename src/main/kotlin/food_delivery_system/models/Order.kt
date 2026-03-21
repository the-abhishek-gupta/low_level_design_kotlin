package food_delivery_system.models

import food_delivery_system.enums.OrderStatus
import java.util.UUID

data class Order(
    private val id: String = UUID.randomUUID().toString(),
    val user: FDUser,
    val restaurant: Restaurant,
    val items: List<OrderItem>,
    var deliveryPartner: DeliveryPartner? = null,
    var orderStatus: OrderStatus = OrderStatus.CREATED
){
    fun getOrderId() = id
}
