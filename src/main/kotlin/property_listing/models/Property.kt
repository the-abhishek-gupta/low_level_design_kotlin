package property_listing.models

import property_listing.enums.PropertyStatus
import java.util.UUID

data class Property(
    private val id: String = UUID.randomUUID().toString(),
    val ownerId: String,
    val price: Double,
    val noOfRooms: Int,
    var propertyStatus: PropertyStatus = PropertyStatus.AVAILABLE
) {
    fun getPropertyId(): String {
        return id
    }
}