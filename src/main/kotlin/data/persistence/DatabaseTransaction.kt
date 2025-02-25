package data.persistence

import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

suspend fun <T> suspendedTransaction(code: Transaction.() -> T): T {
    return newSuspendedTransaction(Dispatchers.IO, statement = code)
}