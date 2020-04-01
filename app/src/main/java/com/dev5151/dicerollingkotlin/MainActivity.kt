package com.dev5151.dicerollingkotlin

import android.content.Intent
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
import androidx.databinding.DataBindingUtil
import com.dev5151.dicerollingkotlin.databinding.ActivityMainBinding
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {


    private lateinit var btn: Button
    private lateinit var dice: ImageView
    private lateinit var tvSwitch: TextView
    private lateinit var rotate: Animation

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*btn = findViewById(R.id.btn)
        dice = findViewById(R.id.dice)
        tvSwitch = findViewById(R.id.tv_switch)
        rotate = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_picture)
*/
        binding.btn.setOnClickListener {
            rollDice()
        }
        binding.tvSwitch.setOnClickListener {
            startActivity(Intent(applicationContext, Main2Activity::class.java))
        }

    }

    private fun rollDice() {
       // binding.apply { binding.dice.startAnimation(rotate) }
        //binding.invalidateAll();
        when (Random().nextInt(6) + 1) {
            1 -> binding.dice.setImageResource(R.drawable.dice_1)
            2 -> binding.dice.setImageResource(R.drawable.dice_2)
            3 -> binding.dice.setImageResource(R.drawable.dice_3)
            4 -> binding.dice.setImageResource(R.drawable.dice_4)
            5 -> binding.dice.setImageResource(R.drawable.dice_5)
            6 -> binding.dice.setImageResource(R.drawable.dice_6)
            else -> {
                Toast.makeText(applicationContext, "ERROR OCCURED", Toast.LENGTH_LONG).show()
            }
        }
    }

}
