package food_delivery_system.strategy.interfaces

import food_delivery_system.models.DeliveryPartner
import food_delivery_system.models.Order

interface DeliveryAssignmentStrategy {
    fun assignPartnersToDelivery(order: Order, deliveryPartnersList: List<DeliveryPartner>): DeliveryPartner?
}