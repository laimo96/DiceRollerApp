package com.example.dicerollerapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // define button and link it to the button in the UI
        val rollButton: Button = findViewById(R.id.button)

        // interaction for a button, after clicking a button it would initiate
        // rollDice function.
        rollButton.setOnClickListener {
            rollDice()
            // to create a Toast message
//            val toast = Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT)//.show() <- another way how to do it
//            toast.show()
        }
        // This line allows to show the dice when the app starts
        rollDice()
    }


    /**
     * function to roll a dice and display the result
     */
    private fun rollDice() {
        // Create a new dice object with 6 sides and then roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        // Display the result in an image view
        val diceImage : ImageView = findViewById(R.id.imageView)
        val diceImage2 : ImageView = findViewById(R.id.imageView2)

        // assign roll dice side to specific drawable images
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        // Update imageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)

        // Update content description
        diceImage.contentDescription = diceRoll.toString()
    }
}


/**
 * class of a Dice, which initiates the roll function and returns a random number
 * between 1 and number of sides.
 */
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}