package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

//  The lateinit keyword promises the Kotlin compiler that the variable will be initialized
//  before the code calls any operations on it. Therefore we don't need to initialize the variable
//  to null here, and we can treat it as a non-nullable variable when we use it. It is a best
//  practice to use lateinit with fields that hold views in just this way.
  lateinit var diceImage : ImageView
  lateinit var diceImage2 : ImageView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

//  GET THE IMAGEVIEW AND ASSIGN IT TO DICEIMAGE
    diceImage = findViewById(R.id.dice_image)
    diceImage2 = findViewById(R.id.dice_image2)

    val rollButton: Button = findViewById(R.id.roll_button)
    rollButton.setOnClickListener {
      rollDice()
    }

//    val addButton: Button = findViewById(R.id.add_button)
//    addButton.setOnClickListener {
//      addNumber()
//    }
//
//    val resetButton: Button = findViewById(R.id.reset_button)
//    resetButton.setOnClickListener {
//      resetNumber()
//    }
  }

  private fun rollDice() {
    //  UPDATE THE SOURCE OF THE IMAGEVIEW
    diceImage.setImageResource(getRandomDiceImage())
    diceImage2.setImageResource(getRandomDiceImage())

    //  DISPLAY THE RESULT AS A TEXTVIEW TEXT
    //  val resultText: TextView = findViewById(R.id.result_text)
    //  resultText.text = randomInt.toString()

    //  DISPLAY TOAST NOTIFICATION
    //  Toast
    //    .makeText(this, "button clicked", Toast.LENGTH_SHORT)
    //    .show()
  }

  private fun getRandomDiceImage(): Int {
    // generate random number in range 1 - 6
    val randomInt = (1..6).random()

    //  SET SPECIFIC IMAGE SOURCE BASED ON RANDOMINT VALUE
    return when (randomInt) {
      1 -> R.drawable.dice_1
      2 -> R.drawable.dice_2
      3 -> R.drawable.dice_3
      4 -> R.drawable.dice_4
      5 -> R.drawable.dice_5
      else -> R.drawable.dice_6
    }
  }

//  private fun addNumber() {
//    var resultText: TextView = findViewById(R.id.result_text)
//
//    when (resultText.text) {
//      "Hello World!" -> resultText.text = "1"
//      else -> {
//        //  The string in TextView views is an instance of class CharSequence.
//        //  To test its value, you need to convert it to a string
//        var parsedResult = resultText.text.toString().toInt()
//        if (parsedResult in 0..5) {
//          parsedResult++
//          resultText.text = parsedResult.toString()
//        }
//      }
//    }
//  }

//  SOLUTION FROM CODELABS GOOGLE
//  private fun addNumber() {
//    val resultText: TextView = findViewById(R.id.result_text)
//
//    // If text is the default "Hello World!" set that text to 1.
//    if (resultText.text == "Hello World!") {
//      resultText.text = "1"
//    } else {
//      // Otherwise, increment the number up to 6.
//      // The text value in resultText.text is an instance of the CharSequence class;
//      // it needs to be converted to a String object before it can be converted to an int.
//      var resultInt = resultText.text.toString().toInt()
//
//      if (resultInt < 6) {
//        resultInt++
//        resultText.text = resultInt.toString()
//      }
//    }
//  }

//  private fun resetNumber() {
//    val resultText: TextView = findViewById(R.id.result_text)
//    resultText.text = "0"
//  }
}
