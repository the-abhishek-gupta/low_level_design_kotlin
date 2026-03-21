package property_listing

import property_listing.enums.SortBy
import property_listing.enums.SortOrder
import property_listing.models.PropertySearchCriteria
import property_listing.models.User
import property_listing.service.PropertyListingService

class PropertyListingMain {
    fun main() {
        val service = PropertyListingService()
        val user1 = User("U1", "Abhishek")
        val user2 = User("U2", "Rahul")

        service.listProperty(
            ownerId = user1.geUserId(),
            price = 9500000.0,
            noOfRooms = 2
        )

        service.listProperty(
            ownerId = user1.geUserId(),
            price = 12500000.0,
            noOfRooms = 3

        )

        service.listProperty(
            ownerId = user2.geUserId(),
            price = 5500000.0,
            noOfRooms = 1
        )
        println("=== Search by price range and sort by price ASC ===")
        val search1 = service.findProperties(
            PropertySearchCriteria(
                minPrice = 5000000.0,
                maxPrice = 10000000.0,
                sortBy = SortBy.PRICE,
                sortOrder = SortOrder.ASC
            )
        )
        search1.forEach { println(it) }

        println()
        println("=== Search by rooms and sort by rooms DESC ===")
        val search2 = service.findProperties(
            PropertySearchCriteria(
                minRooms = 2,
                sortBy = SortBy.ROOMS,
                sortOrder = SortOrder.DESC
            )
        )
        search2.forEach { println(it) }

        println()
//        println("=== Shortlist Property P1 for user2 ===")
//        service.shortlistProperty(user2.id, "P1")
//        service.getShortlistedProperties(user2.id).forEach { println(it) }

        println()
        println("=== Mark P1 as sold by owner ===")
        service.markAsSold("P1")

        println()
        println("=== Search after marking sold ===")
        service.findProperties(PropertySearchCriteria(sortBy = SortBy.PRICE)).forEach { println(it) }
    }
}