package splitwise.models

import java.util.UUID

data class SplitUser( val id: String = UUID.randomUUID().toString(), val name: String)
