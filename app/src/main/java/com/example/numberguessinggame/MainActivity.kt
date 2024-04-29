package com.example.numberguessinggame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //declaring global variable
    private lateinit var EnterGuessButton : Button
    private lateinit var GameResponse : TextView
    private lateinit var GameInput : EditText
    private var randomNumber = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // random number between 1 and 100
        randomNumber = 56

        //reference the button and text boxes
        EnterGuessButton = findViewById(R.id.EnterGuessButton)
        GameResponse = findViewById(R.id.GameResponse)
        GameInput = findViewById(R.id.GameInput)

        EnterGuessButton.setOnClickListener{
            val userGuess = GameInput.text.toString().toIntOrNull()
            if (userGuess != null){
                checkGuess(userGuess)
            } else {
                GameResponse.text = "please enter a valid number"
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun checkGuess(userGuess: Int) {
        when{
            userGuess == randomNumber -> {
                GameResponse.text = "Well done! you guessed the correct number"
            }
            userGuess < randomNumber -> {
                GameResponse.text = "Guess a higher number"
            }
            userGuess > randomNumber -> {
                GameResponse.text = "Guess a lower number"
            }
        }
    }
}
