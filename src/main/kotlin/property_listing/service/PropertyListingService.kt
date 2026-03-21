package property_listing.service

import property_listing.enums.PropertyStatus
import property_listing.interfaces.PropertyRepository
import property_listing.models.Property
import property_listing.models.PropertySearchCriteria

class PropertyListingService(val repository: PropertyRepository = InMemoryPropertyRepository()) {

    fun findProperties(search: PropertySearchCriteria): List<Property> {
        return repository.searchProperty(search)
    }

    fun markAsSold(propertyId: String) {
        repository.updatePropertyStatus(propertyId, PropertyStatus.SOLD)
    }

    fun listProperty(
        ownerId: String,
        noOfRooms: Int,
        price: Double,
    ): String {
        val property = Property(
            ownerId = ownerId,
            price = price,
            noOfRooms = noOfRooms
        )
        repository.addProperty(property)
        return property.getPropertyId()
    }
}