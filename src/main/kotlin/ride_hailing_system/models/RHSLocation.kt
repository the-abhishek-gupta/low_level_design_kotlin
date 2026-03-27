package ride_hailing_system.models

import kotlin.math.abs

data class RHSLocation(val latitude: Double, val longitude: Double) {
    fun calculateDistance(source: RHSLocation): Double {
        return abs(source.latitude - latitude) + abs(source.longitude - longitude)
    }
}
