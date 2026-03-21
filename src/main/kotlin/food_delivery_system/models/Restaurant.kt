package food_delivery_system.models

import java.util.UUID

data class Restaurant(
    private val id: String = UUID.randomUUID().toString(),
    val name: String,
    val menuItems: List<FoodItem> = emptyList(),
    val isOpen: Boolean = true,
)
