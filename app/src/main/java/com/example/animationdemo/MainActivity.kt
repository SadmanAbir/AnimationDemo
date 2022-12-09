package com.example.animationdemo

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    private lateinit var buttonFour: Button
    private lateinit var starImage: ImageView
    private lateinit var sampleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)
        buttonFour = findViewById(R.id.button_four)
        starImage = findViewById(R.id.imageView)
        sampleTextView = findViewById(R.id.sampleTextView)

        val animation = AnimationUtils.loadAnimation(this,R.anim.slide_up)
        starImage.startAnimation(animation)
        sampleTextView.startAnimation(animation)

        var fade_counter = 0

        buttonOne.setOnClickListener{
            Toast.makeText(this, "Button One Clicked", Toast.LENGTH_SHORT).show()
            val animation = ObjectAnimator.ofFloat(starImage, View.ROTATION, 0f, 180f )
            animation.repeatCount = 1
            animation.duration = 1000
            animation.repeatMode = ObjectAnimator.REVERSE
            animation.start()
        }
        buttonTwo.setOnClickListener{
            Toast.makeText(this, "Button Two Clicked", Toast.LENGTH_SHORT).show()
            val animation = AnimationUtils.loadAnimation(this,R.anim.rotation)
            sampleTextView.startAnimation(animation)
        }
        buttonThree.setOnClickListener{
            val animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            starImage.startAnimation(animation)

        }
        buttonFour.setOnClickListener{
            if(fade_counter == 0)
            {
                val animation = AnimationUtils.loadAnimation(this, R.anim.fade)
                starImage.startAnimation(animation)
                fade_counter = 1
            }
            else
            {
                val animation = AnimationUtils.loadAnimation(this, R.anim.unfade)
                starImage.startAnimation(animation)
                fade_counter = 0
            }
        }

    }
}