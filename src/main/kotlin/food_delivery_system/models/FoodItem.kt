package food_delivery_system.models

import java.util.UUID

data class FoodItem(
    val name: String,
    val price: Double
) {

    private val id: String = UUID.randomUUID().toString()
}