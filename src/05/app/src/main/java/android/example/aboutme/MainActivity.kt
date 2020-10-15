package android.example.aboutme

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.done_button)
        // Register the onClick listener with the implementation above
        button.setOnClickListener { view ->
            // do something when the button is clicked
            val editText = findViewById<EditText>(R.id.nickname_edit)
            val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

            nicknameTextView.text = editText.text
            editText.visibility = View.GONE
            view.visibility = View.GONE
            nicknameTextView.visibility = View.VISIBLE
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}