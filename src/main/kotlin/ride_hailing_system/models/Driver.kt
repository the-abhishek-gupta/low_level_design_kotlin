package ride_hailing_system.models

import java.util.UUID

data class Driver(
    private val id: String,
    val name: String,
) {

    var isAvailable: Boolean = true
    var currentLocation: RHSLocation? = null
    fun getId(): String = id

    override fun toString(): String {
        return "Driver(name='$name', isAvailable=$isAvailable, currentLocation=$currentLocation)"
    }
}
