package property_listing.models

import property_listing.enums.SortBy
import property_listing.enums.SortOrder

data class PropertySearchCriteria(
    val minPrice: Double? = null,
    val maxPrice: Double? = null,
    val minRooms: Int? = null,
    val maxRooms: Int? = null,
    val sortBy: SortBy? = null,
    val sortOrder: SortOrder = SortOrder.ASC
)
