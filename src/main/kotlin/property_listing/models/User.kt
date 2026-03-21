package property_listing.models

import java.util.UUID

data class User(private val id: String = UUID.randomUUID().toString(), val name: String) {
    fun geUserId(): String {
        return id
    }
}