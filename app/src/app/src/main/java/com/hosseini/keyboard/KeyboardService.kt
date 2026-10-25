package com.hosseini.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.LinearLayout

class KeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.HORIZONTAL

        val keys = listOf("ق", "ل", "م", "ن", "ا", "⌫", "↵")

        for (key in keys) {
            val button = Button(this)
            button.text = key

            button.setOnClickListener {
                val connection: InputConnection? = currentInputConnection

                when (key) {
                    "⌫" -> connection?.deleteSurroundingText(1, 0)
                    "↵" -> connection?.commitText("\n", 1)
                    else -> connection?.commitText(key, 1)
                }
            }

            layout.addView(button)
        }

        return layout
    }
}
