package food_delivery_system.service

import food_delivery_system.enums.OrderStatus
import food_delivery_system.models.DeliveryPartner
import food_delivery_system.models.FDUser
import food_delivery_system.models.FoodItem
import food_delivery_system.models.Order
import food_delivery_system.models.OrderItem
import food_delivery_system.models.Restaurant
import food_delivery_system.repository.FDRepositoryInMemory
import food_delivery_system.repository.FoodDeliveryRepository

class FoodDeliveryService(private val repository: FoodDeliveryRepository = FDRepositoryInMemory()) {
    fun addUser(user: FDUser) {
        repository.addUser(user)
    }

    fun addRestaurant(name: String): Restaurant {
        val restaurant = Restaurant(name = name)
        repository.addRestaurant(restaurant)
        return restaurant
    }

    fun addDeliveryPartner(partnerName: String) {
        val partner = DeliveryPartner(name = partnerName)
        repository.addDeliveryPartner(partner)
    }

    fun placeOrder(user: FDUser, restaurant: Restaurant, items: List<Pair<FoodItem, Int>>): Order {
        val orderItems = mutableListOf<OrderItem>()
        for ((foodItem, count) in items) {
            orderItems.add(OrderItem(foodItem, count))
        }
        return repository.placeOrder(user, restaurant, orderItems)
    }

    fun updateOrderStatus(order: Order, delivered: OrderStatus) {
        repository.updateOrderStatus(order, delivered)
    }

    fun getOrderStatus(order: Order): OrderStatus {
        return order.orderStatus
    }


}