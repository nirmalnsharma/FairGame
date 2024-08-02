package com.example.fairgame

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddMoneyActivity : AppCompatActivity() {

    private lateinit var amountEditText: EditText
    private lateinit var addButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_money)

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)

        amountEditText = findViewById(R.id.amountEditText)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val amount = amountEditText.text.toString().toFloatOrNull()
            if (amount != null && amount > 0) {
                val currentBalance = sharedPreferences.getFloat("balance", 0.0f)
                val newBalance = currentBalance + amount
                sharedPreferences.edit().putFloat("balance", newBalance).apply()
                Toast.makeText(this, "Amount added: ₹$amount", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}