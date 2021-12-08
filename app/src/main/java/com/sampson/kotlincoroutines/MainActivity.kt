package com.sampson.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtBaseText = findViewById<EditText>(R.id.edtMainActivityBaseText)
        val btnStart = findViewById<Button>(R.id.btnMainActivityStartCoroutine)
        val txtShowResult = findViewById<TextView>(R.id.txtMainActivityShowResult)
        val txtShowTimesRepeated = findViewById<TextView>(R.id.txtMainActivityShowTimesRepeated)
    }
}