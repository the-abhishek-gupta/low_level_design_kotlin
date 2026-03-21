package bookmyshow

import bookmyshow.pricing_strategy.DefaultPricingStrategy
import bookmyshow.pricing_strategy.PricingStrategy

class BMSService(val pricingStrategy: PricingStrategy = DefaultPricingStrategy()) {

    val bookingsMap = mutableMapOf<String, Booking>()
    val showsMap = mutableMapOf<String, Show>()

    fun bookSeats(userId: String, showId: String, seatsToBook: List<Seat>): Booking? {

        val show = showsMap[showId] ?: return null
        val showSeats = show.showSeats.filter { it.seat in seatsToBook }
        if (showSeats.size != seatsToBook.size) {
            return null
        }
        if (showSeats.any { it.status == SeatStatus.BOOKED }) return null

        val seatList = mutableListOf<Seat>()
        showSeats.forEach { it ->
            seatList.add(it.seat)
        }

        val amount = pricingStrategy.calculatePrice(seatList)
        val booking = Booking(
            userId = userId,
            show = show,
            seats = seatList,
            totalAmount = amount,
            status = BookingStatus.CONFIRMED
        )

        bookingsMap[booking.getBookingId()] = booking
        return booking
    }
}