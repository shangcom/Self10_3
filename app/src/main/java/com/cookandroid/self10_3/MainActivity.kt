package com.cookandroid.self10_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "메인 액티비티"

        val edtNum1 = findViewById<EditText>(R.id.edtNum1)
        val edtNum2 = findViewById<EditText>(R.id.edtNum2)
        val rdoGroup = findViewById<RadioGroup>(R.id.rdoGroup)

        val btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)

            when (rdoGroup.checkedRadioButtonId) {
                R.id.rdoAdd -> intent.putExtra("Calc", "+")
                R.id.rdoSub -> intent.putExtra("Calc", "-")
                R.id.rdoMul -> intent.putExtra("Calc", "*")
                R.id.rdoDiv -> intent.putExtra("Calc", "/")
            }

            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))

            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && data != null) {
            val hap = data.getIntExtra("Hap", 0)
            Toast.makeText(this, "결과 : $hap", Toast.LENGTH_SHORT).show()
        }
    }
}
