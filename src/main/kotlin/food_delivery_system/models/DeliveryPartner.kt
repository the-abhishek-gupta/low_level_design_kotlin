package food_delivery_system.models

import java.util.UUID

data class DeliveryPartner(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    var isAvailable: Boolean = true
)
