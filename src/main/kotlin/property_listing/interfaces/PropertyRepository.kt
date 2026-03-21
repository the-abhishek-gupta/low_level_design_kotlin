package property_listing.interfaces

import property_listing.enums.PropertyStatus
import property_listing.models.Property
import property_listing.models.PropertySearchCriteria

interface PropertyRepository {
    fun addProperty(property: Property)
    fun searchProperty(criteria: PropertySearchCriteria): List<Property>
    fun updatePropertyStatus(id: String, status: PropertyStatus)
}