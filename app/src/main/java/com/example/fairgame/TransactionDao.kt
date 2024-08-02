package com.example.fairgame

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert
    suspend fun insert(transaction: Transaction): Long

    @Query("SELECT * FROM transactions WHERE status = :status")
    fun getTransactionsByStatus(status: String): List<Transaction>

    @Update
    suspend fun update(transaction: Transaction): Int

    @Query("SELECT COALESCE(SUM(amount), 0) FROM transactions WHERE status = 'approved'")
    fun getBalance(): Float

    @Query("UPDATE user_balance SET balance = :newBalance WHERE id = 1")
    suspend fun updateBalance(newBalance: Float): Int
}