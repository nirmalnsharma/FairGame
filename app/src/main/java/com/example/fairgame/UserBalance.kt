package com.example.fairgame

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_balance")
data class UserBalance(
    @PrimaryKey val id: Int = 1,
    val balance: Float
)