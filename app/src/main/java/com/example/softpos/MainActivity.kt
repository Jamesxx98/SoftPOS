package com.example.softpos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartTransaction = findViewById<Button>(R.id.button)
        btnStartTransaction.setOnClickListener {
            startActivity(Intent(this, TransactionActivity::class.java))
        }
    }
}