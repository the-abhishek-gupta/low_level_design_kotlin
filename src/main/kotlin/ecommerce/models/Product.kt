package ecommerce.models

import java.util.UUID

data class Product(
    private val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double,
) {

    fun getProductId(): String = id
}
