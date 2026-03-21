package food_delivery_system

import food_delivery_system.enums.OrderStatus
import food_delivery_system.models.FDUser
import food_delivery_system.models.FoodItem
import food_delivery_system.service.FoodDeliveryService

class FoodDeliveryMain {
    fun main() {
        val service = FoodDeliveryService()

        val user1 = FDUser(name = "Abhishek", email =  "")
        service.addUser(user1)

        val restaurant1 = service.addRestaurant(name = "Dominos")

        service.addDeliveryPartner( "Rider1")
        service.addDeliveryPartner("Rider2")

        val foodItem1 = FoodItem("Item 1", 15.0)
        val foodItem2 = FoodItem("Item 1", 15.0)

        val order = service.placeOrder(
            user = user1,
            restaurant = restaurant1,
            items = listOf(foodItem1 to 1, foodItem2 to 2)
        )

        println("Order placed: $order")

        service.updateOrderStatus(order, OrderStatus.DELIVERED)

        println("Order status: ${service.getOrderStatus(order)}")

        println("Order: $order")

    }
}