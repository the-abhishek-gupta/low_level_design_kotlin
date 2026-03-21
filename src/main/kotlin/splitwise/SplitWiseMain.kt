package splitwise

import splitwise.enums.SPLIT_BY
import splitwise.models.SplitExpense
import splitwise.service.SplitWiseService

class SplitWiseMain {
    fun main() {
        val splitWiseService = SplitWiseService()

        val splitUser1 = splitWiseService.addUser("A")
        val splitUser2 = splitWiseService.addUser("B")
        val splitUser3 = splitWiseService.addUser("C")

        val splitGroup = splitWiseService.addGroup("House")

        splitWiseService.addUserToGroup(splitUser1.id, splitGroup.groupId)
        splitWiseService.addUserToGroup(splitUser2.id, splitGroup.groupId)
        splitWiseService.addUserToGroup(splitUser3.id, splitGroup.groupId)

        val splitExpense1 = SplitExpense(
            paidBy = splitUser1.id,
            amount = 30.0,
            splitUsers = listOf(splitUser1, splitUser2, splitUser3),
            splitBy = SPLIT_BY.EQUALLY,
        )
        val splitExpense2 = SplitExpense(
            paidBy = splitUser2.id,
            amount = 60.0,
            splitUsers = listOf( splitUser1, splitUser2, splitUser3),
            splitBy = SPLIT_BY.EQUALLY,
        )
        splitWiseService.addExpenseToGroup(splitExpense1, splitGroup.groupId)
        splitWiseService.getUserBalanceForGroup(splitGroup.groupId)
        println()
        splitWiseService.addExpenseToGroup(splitExpense2, splitGroup.groupId)
        splitWiseService.getUserBalanceForGroup(splitGroup.groupId)
    }
}