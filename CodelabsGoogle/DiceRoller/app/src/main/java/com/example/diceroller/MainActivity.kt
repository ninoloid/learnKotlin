package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val rollButton: Button = findViewById(R.id.roll_button)
    rollButton.setOnClickListener {
      rollDice()
    }

    val addButton: Button = findViewById(R.id.add_button)
    addButton.setOnClickListener {
      addNumber()
    }
  }

  private fun rollDice() {
    var resultText: TextView = findViewById(R.id.result_text)

    // generate random number in range 1 - 6
    val randomInt = (1..6).random()
    resultText.text = randomInt.toString()

//    DISPLAY TOAST NOTIFICATION
//    Toast
//      .makeText(this, "button clicked", Toast.LENGTH_SHORT)
//      .show()
  }

  private fun addNumber() {
    var resultText: TextView = findViewById(R.id.result_text)

    when (resultText.text) {
      "Hello World!" -> resultText.text = "1"
      else -> {
        //  The string in TextView views is an instance of class CharSequence.
        //  To test its value, you need to convert it to a string
        var parsedResult = resultText.text.toString().toInt()
        if (parsedResult in 1..5) {
          parsedResult++
          resultText.text = parsedResult.toString()
        }
      }
    }
  }

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
}
