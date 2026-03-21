package ecommerce.models

import java.util.UUID

data class User(
    private val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String = "",
) {
    fun getUserId(): String = id

}
