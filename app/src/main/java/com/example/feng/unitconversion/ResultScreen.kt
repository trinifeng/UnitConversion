package com.example.feng.unitconversion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ResultScreen : AppCompatActivity() {

    lateinit var resultOutput: TextView
    lateinit var switchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.clip_art_icon)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        resultOutput = findViewById(R.id.result_output)
        switchButton = findViewById(R.id.switch_button)

        val result = intent.getStringExtra("EXTRA_RESULT")

        resultOutput.text = result

        switchButton.setOnClickListener{
            Intent(this@ResultScreen, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}