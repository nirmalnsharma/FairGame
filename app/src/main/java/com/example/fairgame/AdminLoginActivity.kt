package com.example.fairgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminLoginActivity : AppCompatActivity() {

    private lateinit var adminUsername: EditText
    private lateinit var adminPassword: EditText
    private lateinit var adminLoginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_login)

        adminUsername = findViewById(R.id.adminUsername)
        adminPassword = findViewById(R.id.adminPassword)
        adminLoginButton = findViewById(R.id.adminLoginButton)

        adminLoginButton.setOnClickListener {
            val username = adminUsername.text.toString()
            val password = adminPassword.text.toString()

            if (username == "abc" && password == "abc") {
                val intent = Intent(this, AdminPanelActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}