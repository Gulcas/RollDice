package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView //i need to declare that diceImage won't be a null value
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button =
            findViewById(R.id.roll_button) //created value and connected with button in layout xml file
        rollButton.text =
            getString(R.string.roll) //code will change what is displayed on value specified before- button this time
        rollButton.setOnClickListener {
            //code will set up listener that will do below code when button will be clicked
            Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show()
            rollDice() //method will be done when button will be clicked
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text) //assign xml view to kotlin value
        val randomInt =
            Random.nextInt(6) + 1 //create random int value, random number will be in bounds 0-5 so I had to add 1 to avoid 0 number on dice
        resultText.text = randomInt.toString() //assign created random int value to previously created text value
        val drawableResource =
            when (randomInt) { //created value that is using when function to assign random number to the image
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        diceImage.setImageResource(drawableResource) //setting created previously value of image to the xml value image
    }
}
