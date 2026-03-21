package splitwise.models

import splitwise.enums.SPLIT_BY
import java.util.UUID

data class SplitExpense(
    private val id: String = UUID.randomUUID().toString(),
    val paidBy: String,
    val amount: Double,
    val splitUsers: List<SplitUser>,
    val splitBy : SPLIT_BY
)