package com.cookandroid.self10_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"

        val calc = intent.getStringExtra("Calc") ?: "+"
        val num1 = intent.getIntExtra("Num1", 0)
        val num2 = intent.getIntExtra("Num2", 0)
        val calValue = when (calc) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0) num1 / num2 else 0
            else -> 0
        }

        findViewById<Button>(R.id.btnReturn).setOnClickListener {
            val outIntent = Intent().apply {
                putExtra("Hap", calValue)
            }
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}
