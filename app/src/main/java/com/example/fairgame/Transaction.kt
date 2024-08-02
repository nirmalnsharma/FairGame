package com.example.fairgame

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class Transaction(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val transactionId: String,
    val amount: Float,
    val status: String = "pending"
)