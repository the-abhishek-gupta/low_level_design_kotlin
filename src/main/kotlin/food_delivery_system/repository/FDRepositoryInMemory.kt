package food_delivery_system.repository

import food_delivery_system.enums.OrderStatus
import food_delivery_system.models.DeliveryPartner
import food_delivery_system.models.FDUser
import food_delivery_system.models.Order
import food_delivery_system.models.OrderItem
import food_delivery_system.models.Restaurant
import food_delivery_system.strategy.NearestDeliveryPartnerAssignmentStrategy
import food_delivery_system.strategy.interfaces.DeliveryAssignmentStrategy

class FDRepositoryInMemory(
    val strategy: DeliveryAssignmentStrategy = NearestDeliveryPartnerAssignmentStrategy()
) :
    FoodDeliveryRepository {

    val usersMap = mutableMapOf<String, FDUser>()
    val restaurantsMap = mutableMapOf<String, Restaurant>()
    val deliveryPartners = mutableListOf<DeliveryPartner>()

    val ordersMap = mutableMapOf<String, Order>()


    override fun addRestaurant(restaurant: Restaurant) {
        restaurantsMap[restaurant.name] = restaurant
    }

    override fun searchRestaurants(): List<Restaurant> {
        return restaurantsMap.values.filter { it.isOpen }.toList()
    }

    override fun placeOrder(user: FDUser, restaurant: Restaurant, items: List<OrderItem>): Order {
        val foodOrder = Order(
            user = user,
            restaurant = restaurant,
            items = items
        )
        val deliveryPartner = strategy.assignPartnersToDelivery(foodOrder, deliveryPartners)
        if (deliveryPartner != null) {
            deliveryPartner.isAvailable = false
            foodOrder.deliveryPartner = deliveryPartner
            foodOrder.orderStatus = OrderStatus.OUT_FOR_DELIVERY
        }
        ordersMap[foodOrder.getOrderId()] = foodOrder
        return foodOrder
    }

    override fun addUser(user: FDUser) {
        usersMap[user.getUserId()] = user
    }

    override fun updateOrderStatus(order: Order, orderStatus: OrderStatus) {
        order.orderStatus = orderStatus

        if (orderStatus == OrderStatus.DELIVERED) {
            order.deliveryPartner?.isAvailable = true
        }
    }

    override fun addDeliveryPartner(deliveryPartner: DeliveryPartner) {
        deliveryPartners.add(deliveryPartner)
    }
}