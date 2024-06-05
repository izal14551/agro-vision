package com.capstone.agrovision

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btnRegister = findViewById<Button>(R.id.btnSignup) // Initialize the login button
        val btnBackToLogin = findViewById<Button>(R.id.loginTab)

        btnRegister.setOnClickListener {
            // Logika untuk mendaftarkan pengguna baru
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnBackToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}