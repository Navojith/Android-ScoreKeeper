package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView
    var mScore1 : Int = 0
    var mScore2 : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById<TextView>(R.id.score_1)
        mScoreText2 = findViewById<TextView>(R.id.score_2)

        mScore1 = mScoreText1?.text.toString().toInt()
        mScore2 = mScoreText2?.text.toString().toInt()
    }

    fun decreaseScore(view: View) {

        when(view.id) {
            R.id.decreaseTeam1 -> {
                mScore1--;
                mScoreText1.text= mScore1.toString()
            }

            R.id.decreaseTeam2 -> {
                mScore2--
                mScoreText2.text= mScore2.toString()
            }

            else -> {
                println("Invalid")
            }
        }
    }

    fun increaseScore(view: View) {
        when(view.id) {
            R.id.increaseTeam1 -> {
                mScore1++;
                mScoreText1.text = mScore1.toString()
            }

            R.id.increaseTeam2 -> {
                mScore2++
                mScoreText2.text= mScore2.toString()
            }

            else ->  {
                println("Invalid")
            }
        }
    }
}