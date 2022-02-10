package com.example.bottomsheetdialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var test = findViewById<TextView>(R.id.test_btn)

        test.setOnClickListener {
            var fragment = BottomCalendar()

            fragment.show(
                supportFragmentManager,
                BottomCalendar::class.java.simpleName
            )
        }
    }
}