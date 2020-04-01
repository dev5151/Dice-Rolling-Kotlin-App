package com.dev5151.dicerollingkotlin

import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    private lateinit var btn: Button
    private lateinit var dice: ImageView
    private lateinit var rotate: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)
        dice = findViewById(R.id.dice)
        rotate = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_picture)

        btn.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        dice.startAnimation(rotate)
        when (Random().nextInt(6) + 1) {
            1 -> dice.setImageResource(R.drawable.dice_1)
            2 -> dice.setImageResource(R.drawable.dice_2)
            3 -> dice.setImageResource(R.drawable.dice_3)
            4 -> dice.setImageResource(R.drawable.dice_4)
            5 -> dice.setImageResource(R.drawable.dice_5)
            6 -> dice.setImageResource(R.drawable.dice_6)
            else -> {
                Toast.makeText(applicationContext, "ERROR OCCURED", Toast.LENGTH_LONG).show()
            }
        }
    }

}
