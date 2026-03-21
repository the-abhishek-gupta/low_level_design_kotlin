package food_delivery_system.strategy

import food_delivery_system.models.DeliveryPartner
import food_delivery_system.models.Order
import food_delivery_system.strategy.interfaces.DeliveryAssignmentStrategy

class NearestDeliveryPartnerAssignmentStrategy : DeliveryAssignmentStrategy {
    override fun assignPartnersToDelivery(
        order: Order,
        deliveryPartnersList: List<DeliveryPartner>
    ): DeliveryPartner? {
        return deliveryPartnersList.firstOrNull { it.isAvailable }
    }
}