package com.hosseini.keyboard

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.content.Context
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(24, 24, 24, 24)

        val title = TextView(this)
        title.text = "حسینی کیبورد"
        title.textSize = 28f
        title.gravity = Gravity.CENTER

        val button = Button(this)
        button.text = "باز کردن کیبورد"
        button.setOnClickListener {
            val manager = getSystemService(
                Context.INPUT_METHOD_SERVICE
            ) as InputMethodManager
            manager.showInputMethodPicker()
        }

        layout.addView(title)
        layout.addView(button)
        setContentView(layout)
    }
}
