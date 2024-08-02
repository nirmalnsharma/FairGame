package com.example.fairgame

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Transaction::class, UserBalance::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
}