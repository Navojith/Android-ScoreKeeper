package com.example.scorekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    private lateinit var mScoreText1: TextView
    private lateinit var mScoreText2: TextView
    var mScore1 : Int = 0
    var mScore2 : Int = 0

    val STATE_SCORE_1 = "Team 1 Score"
    val STATE_SCORE_2 = "Team 2 Score"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById<TextView>(R.id.score_1)
        mScoreText2 = findViewById<TextView>(R.id.score_2)

        mScore1 = mScoreText1?.text.toString().toInt()
        mScore2 = mScoreText2?.text.toString().toInt()

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            // Set the score text views.
            mScoreText1.text = mScore1.toString();
            mScoreText2.text = mScore2.toString();
        }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu!!.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu!!.findItem(R.id.night_mode).setTitle(R.string.night_mode)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.night_mode) {
            var nightMode = AppCompatDelegate.getDefaultNightMode();

            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
        return super.onOptionsItemSelected(item)
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

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }
}