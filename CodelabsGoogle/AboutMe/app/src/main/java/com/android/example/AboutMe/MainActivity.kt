package com.android.example.AboutMe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // the button click listener
    findViewById<Button>(R.id.done_button).setOnClickListener {
      // it <-- the button itself
      addNickname(it)
    }

    // the nickname_text click listener
    findViewById<TextView>(R.id.nickname_text).setOnClickListener {
      updateNickname(it)
    }
  }

  private fun addNickname(view: View) {
    val editText = findViewById<EditText>(R.id.nickname_edit)
    val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

    // set nicknameTextView value to the value of editText
    nicknameTextView.text = editText.text

    // hide the editText
    // the "GONE" doesn't take up any space in the layout
    editText.visibility = View.GONE

    // hide the button. we already have the button's reference as the function's input parameter, view
    view.visibility = View.GONE

    // show the nicknameTextView
    nicknameTextView.visibility = View.VISIBLE

    // hide the keyboard after done is clicked
    val androidKey = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    androidKey.hideSoftInputFromWindow(view.windowToken, 0)
  }

  private fun updateNickname(view: View) {
    val editText = findViewById<EditText>(R.id.nickname_edit)
    val doneButton = findViewById<Button>(R.id.done_button)

    editText.visibility = View.VISIBLE
    doneButton.visibility = View.VISIBLE
    view.visibility = View.GONE

    // set the focus to the edit text
    editText.requestFocus()

    // without this, the keyboard isn't visible
    val androidKey = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    androidKey.showSoftInput(editText, 0)
  }
}
