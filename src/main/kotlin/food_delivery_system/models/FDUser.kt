package food_delivery_system.models

import java.util.UUID

data class FDUser(
    private val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String
) {
    fun getUserId(): String {
        return id
    }
}