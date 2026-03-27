package ride_hailing_system.models

import java.util.UUID

data class Rider(val name : String){
    private val id : String = UUID.randomUUID().toString()
    fun getId() : String = id
}
