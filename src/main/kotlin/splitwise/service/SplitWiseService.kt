package splitwise.service

import splitwise.interfaces.repository.InMemorySplitwiseRepository
import splitwise.interfaces.repository.SplitWiseRepository
import splitwise.models.SplitExpense
import splitwise.models.SplitGroup
import splitwise.models.SplitUser

class SplitWiseService(val repository: SplitWiseRepository = InMemorySplitwiseRepository()) {
    fun addUser(userName: String): SplitUser {
        val user = SplitUser(name = userName)
        repository.addUser(user)
        return user
    }

    fun addGroup(group: String): SplitGroup {
        val group = SplitGroup(name = group)
        repository.addGroup(group)
        return group
    }

    fun addUserToGroup(user: String, groupId: String) {
        repository.addUserToGroup(user, groupId)
    }

    fun addExpenseToGroup(expense: SplitExpense, groupId: String) {
        repository.addExpenseToGroup(expense, groupId)
    }

    fun getUserBalanceForGroup(groupId: String){
        repository.getUserBalanceForGroup(groupId)
    }
}