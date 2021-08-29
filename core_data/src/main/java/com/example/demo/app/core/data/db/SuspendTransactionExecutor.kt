package com.example.demo.app.core.data.db

import androidx.room.withTransaction

class SuspendTransactionExecutor(private val database: AppDatabase) {

    suspend fun inTransaction(transactionBody: suspend () -> Unit) {
        database.withTransaction {
            transactionBody()
        }
    }
}