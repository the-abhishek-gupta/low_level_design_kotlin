package splitwise.interfaces.repository

import splitwise.models.SplitExpense
import splitwise.models.SplitGroup
import splitwise.models.SplitUser

interface SplitWiseRepository {
    fun addUser(user: SplitUser)
    fun addGroup(group : SplitGroup)
    fun addUserToGroup(user: String, groupId : String)
    fun addExpenseToGroup(expense : SplitExpense, groupId: String)
    fun getUserBalanceForGroup(groupId: String)
}