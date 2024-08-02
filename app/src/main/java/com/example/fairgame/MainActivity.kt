package com.example.fairgame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FairGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    var transactionId by remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Account Balance: ${viewModel.balance}", style = MaterialTheme.typography.h5)

        if (viewModel.balance < 2.0) {
            Text("You need at least 2 rupees to play the game.")
            Button(onClick = { /* QR code generation logic */ }) {
                Text("Add Money")
            }
        } else {
            // Game playing logic
        }

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = transactionId,
            onValueChange = { transactionId = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Button(onClick = { viewModel.submitTransaction(transactionId.text) }) {
            Text("Submit Transaction ID")
        }
    }
}