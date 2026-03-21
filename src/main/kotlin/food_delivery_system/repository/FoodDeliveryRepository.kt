package food_delivery_system.repository

import food_delivery_system.enums.OrderStatus
import food_delivery_system.models.DeliveryPartner
import food_delivery_system.models.FDUser
import food_delivery_system.models.FoodItem
import food_delivery_system.models.Order
import food_delivery_system.models.OrderItem
import food_delivery_system.models.Restaurant

interface FoodDeliveryRepository {

    fun addRestaurant(restaurant: Restaurant)

    fun searchRestaurants(): List<Restaurant>

    fun addDeliveryPartner(deliveryPartner: DeliveryPartner)

    fun placeOrder(user: FDUser, restaurant: Restaurant, items: List<OrderItem>): Order

    fun addUser(user: FDUser)

    fun updateOrderStatus(order: Order, orderStatus: OrderStatus)
}