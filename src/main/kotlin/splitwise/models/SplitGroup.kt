package splitwise.models

import java.util.UUID

data class SplitGroup(
    val groupId: String = UUID.randomUUID().toString(),
    val name: String,
    val members: List<String> = emptyList()
)