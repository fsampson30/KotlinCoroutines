package com.sampson.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var times = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtBaseText = findViewById<EditText>(R.id.edtMainActivityBaseText)
        val btnStart = findViewById<Button>(R.id.btnMainActivityStartCoroutine)
        val txtShowResult = findViewById<TextView>(R.id.txtMainActivityShowResult)
        val txtShowTimesRepeated = findViewById<TextView>(R.id.txtMainActivityShowTimesRepeated)

        btnStart.setOnClickListener {
            txtShowResult.text = edtBaseText.text
            runBlocking {
                repeat(100) {
                    launch {
                        txtShowTimesRepeated.text = doTimesRepeated()
                    }
                }
                async {
                    val msg = showMessage()
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                }
            }
            Toast.makeText(this, "Finish",Toast.LENGTH_SHORT).show()
        }
    }

    private suspend fun doTimesRepeated(): String {
        delay(2000L)
        return times++.toString()
    }

    private suspend fun showMessage(): String {
        delay(3000)
        return "Returning"
    }

}