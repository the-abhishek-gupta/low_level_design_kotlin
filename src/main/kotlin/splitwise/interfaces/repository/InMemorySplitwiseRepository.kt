package splitwise.interfaces.repository

import splitwise.enums.SPLIT_BY
import splitwise.models.SplitExpense
import splitwise.models.SplitGroup
import splitwise.models.SplitUser
import kotlin.math.min

class InMemorySplitwiseRepository : SplitWiseRepository {
    private val users = mutableMapOf<String, SplitUser>()
    private val groups = mutableMapOf<String, SplitGroup>()

    private val groupBalances = mutableMapOf<String, MutableMap<String, MutableMap<String, Double>>>()

    override fun addUser(user: SplitUser) {
        users[user.id] = user
    }

    override fun addGroup(group: SplitGroup) {
        groups[group.groupId] = group
    }

    override fun addUserToGroup(user: String, groupId: String) {
        val group = groups[groupId] ?: throw IllegalArgumentException("Group with id $groupId doesn't exist")
        users[user] ?: throw IllegalArgumentException("User with id $user doesn't exist")
        val updatedGroup = group.copy(members = group.members + user)
        groups[group.groupId] = updatedGroup
    }

    override fun addExpenseToGroup(expense: SplitExpense, groupId: String) {
        val group = groups[groupId] ?: throw IllegalArgumentException("Group with id $groupId doesn't exist")
        expense.splitUsers.forEach { user ->
            require(group.members.contains(user.id)) {
                "User ${user.id} not in group"
            }
        }
        when (expense.splitBy) {
            SPLIT_BY.EQUALLY -> applyEqualSplit(expense, groupId)
        }
    }

    override fun getUserBalanceForGroup(groupId: String) {
        val balances = groupBalances[groupId] ?: return

        println("---- Balances for group $groupId ----")

        balances.forEach { (user, owesMap) ->
            owesMap.forEach { (other, amount) ->
                if (amount > 0.0) {
                    println("${users[user]?.name} owes ${users[other]?.name}: ₹$amount")
                }
            }
        }
    }

    private fun applyEqualSplit(expense: SplitExpense, groupId: String) {
        val balances = groupBalances.getOrPut(groupId, { mutableMapOf() })
        val payer = expense.paidBy
        val owedAmount = expense.amount / expense.splitUsers.size
        expense.splitUsers.forEach { udhari ->
            if (udhari.id == payer) return@forEach
            val userBalanceMap = balances.getOrPut(udhari.id, { mutableMapOf() })
            userBalanceMap[payer] = userBalanceMap.getOrDefault(payer, 0.0) + owedAmount

            val payerBalanceMap = balances.getOrPut(payer, { mutableMapOf() })
            val udhar = payerBalanceMap[udhari.id] ?: 0.0

            if (udhar > 0) {
                val min = min(udhar, owedAmount)
                payerBalanceMap[udhari.id] = udhar - min
                userBalanceMap[payer] = userBalanceMap[payer]!! - min
            }

        }
    }
}