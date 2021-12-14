package com.sampson.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
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
        val btnRollDice = findViewById<Button>(R.id.btnMainActivityRollDice)
        val txtNumerRolls = findViewById<TextView>(R.id.txtMainActivityNumberRolls)
        val imgView = findViewById<ImageView>(R.id.imgViewMainActivityDice)

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

        btnRollDice.setOnClickListener {
            rollDice()
            val number = randomDiceNumber()
            txtNumerRolls.text = number
            imgView.setImageResource(drawableResourse(number.toInt()))
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

    private fun rollDice() {
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
    }

    private fun randomDiceNumber(): String {
        return (1..6).random().toString()
    }

    private fun drawableResourse(param : Int) : Int {
        val diceImage : Int
        when (param) {
            1 -> diceImage = R.drawable.dice_1
            2 -> diceImage = R.drawable.dice_2
            3 -> diceImage = R.drawable.dice_3
            4 -> diceImage = R.drawable.dice_4
            5 -> diceImage = R.drawable.dice_5
            6 -> diceImage = R.drawable.dice_6
            else -> diceImage = R.drawable.empty_dice
        }
        return diceImage
    }

}