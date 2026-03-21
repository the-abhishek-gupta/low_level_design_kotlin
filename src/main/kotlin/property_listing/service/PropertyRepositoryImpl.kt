package property_listing.service

import property_listing.enums.PropertyStatus
import property_listing.interfaces.PropertyRepository
import property_listing.models.Property
import property_listing.models.PropertySearchCriteria
import java.util.concurrent.ConcurrentHashMap

class InMemoryPropertyRepository : PropertyRepository {

    val properties = ConcurrentHashMap<String, Property>()
    override fun addProperty(property: Property) {
        properties[property.getPropertyId()] = property
    }

    override fun searchProperty(criteria: PropertySearchCriteria): List<Property> {
        val result = properties.values.filter {
            (it.propertyStatus == PropertyStatus.AVAILABLE) &&
                    (criteria.minPrice == null || criteria.minPrice <= it.price) &&
                    (criteria.maxPrice == null || criteria.maxPrice >= it.price) &&
                    (criteria.minRooms == null || criteria.minRooms <= it.noOfRooms) &&
                    (criteria.maxRooms == null || criteria.maxRooms >= it.noOfRooms)
        }.toList()
        return result
    }

    override fun updatePropertyStatus(id: String, status: PropertyStatus) {
        properties[id]?.propertyStatus = status
    }
}