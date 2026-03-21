package bookmyshow

import java.util.UUID

data class Booking(
    private val bookingId: String = UUID.randomUUID().toString(),
    val userId: String,
    val show: Show,
    val seats: List<Seat>,
    val totalAmount: Double,
    val status: BookingStatus
) {
    fun getBookingId(): String {
        return bookingId
    }
}