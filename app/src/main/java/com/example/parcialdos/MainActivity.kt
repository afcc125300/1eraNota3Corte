package com.example.parcialdos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.BreakIterator


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.loginbtn)
        btn.setOnClickListener {

            val intent: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}