package com.example.fairgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class AdminPanelActivity : ComponentActivity() {

    private val viewModel: AdminPanelViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FairGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AdminPanelScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun AdminPanelScreen(viewModel: AdminPanelViewModel = viewModel()) {
    val transactions by viewModel.transactions.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Pending Transactions", style = MaterialTheme.typography.h5)

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(transactions) { transaction ->
                TransactionItem(transaction)
            }
        }
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Transaction ID: ${transaction.transactionId}")
            Text("Amount: ${transaction.amount}")
            Button(onClick = { /* Approve transaction logic */ }) {
                Text("Approve")
            }
        }
    }
}