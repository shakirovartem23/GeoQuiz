package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    interface CallbackAnswer{
        fun isResult(answer: Boolean)
    }

    fun getResult(callBackAnswer: CallbackAnswer, answerTrue: Button, answerFalse: Button){
        answerTrue.setOnClickListener{
            callBackAnswer.isResult(true)
            answerTrue.isClickable = false
            answerTrue.isFocusable = false
            answerFalse.isClickable = false
            answerFalse.isFocusable = false
        }

        answerFalse.setOnClickListener {
            callBackAnswer.isResult(false)
            answerTrue.isClickable = false
            answerTrue.isFocusable = false
            answerFalse.isClickable = false
            answerFalse.isFocusable = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answerTrue = findViewById<Button>(R.id.answerTrue)
        val answerFalse = findViewById<Button>(R.id.answerFalse)

        val answer = object : CallbackAnswer {
            override fun isResult(answer: Boolean) {
                if(answer){
                    val notify = Toast.makeText(this@MainActivity, "Right!", Toast.LENGTH_SHORT)
                    notify.setGravity(Gravity.TOP, 0, 0)
                    notify.show()
                } else {
                    val notify = Toast.makeText(this@MainActivity, "Incorrect!", Toast.LENGTH_SHORT)
                    notify.setGravity(Gravity.TOP, 0, 0)
                    notify.show()
                }
            }
        }

        getResult(answer, answerTrue, answerFalse)
    }
}