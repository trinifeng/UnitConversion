package com.example.feng.unitconversion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var usd2pounds: RadioButton
    lateinit var pounds2usd: RadioButton
    lateinit var numberInput: EditText
    lateinit var convertButton: Button
    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.clip_art_icon)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        var resultText: String? = ""

        usd2pounds = findViewById(R.id.radio_button_1)
        pounds2usd = findViewById(R.id.radio_button_2)
        numberInput = findViewById(R.id.number_input)
        convertButton = findViewById(R.id.converter_button)

        radioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            radioButton = findViewById(checkedId)
            Toast.makeText(applicationContext, "You Selected: ${radioButton.text}", Toast.LENGTH_SHORT).show()
        }

        convertButton.setOnClickListener{
            val num = numberInput.text.toString().toDouble()
            val conversionRate = 0.85
            var convertedNumber: Double?

            if(usd2pounds.isChecked) {
                if(num <= 10000){
                    convertedNumber = num * conversionRate
                    val poundFormat = DecimalFormat("\uFFE1##.##")
                    resultText = poundFormat.format(convertedNumber)
                }
                else {
                    Toast.makeText(this@MainActivity, "Currency input must be less than 10,000", Toast.LENGTH_SHORT).show()
                }
            }

            if(pounds2usd.isChecked) {
                if(num <= 10000){
                    convertedNumber = num / conversionRate
                    val usdFormat = DecimalFormat("\uFF04##.##")
                    resultText = usdFormat.format(convertedNumber)
                }
                else {
                    Toast.makeText(this@MainActivity, "Currency input must be less than 10,000", Toast.LENGTH_SHORT).show()
                }
            }

            Intent(this@MainActivity, ResultScreen::class.java).also {
                it.putExtra("EXTRA_RESULT", resultText)
                startActivity(it)
            }

        }
    }
}