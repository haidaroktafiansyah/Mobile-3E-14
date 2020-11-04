package android.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.example.aboutme.databinding.ActivityMainBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Haidar Oktafiansyah")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val button: Button = binding.doneButton
        // Register the onClick listener with the implementation above
        button.setOnClickListener { view ->
            // do something when the button is clicked
            binding.myName = myName
            val editText = binding.nicknameEdit
            val nicknameTextView = binding.nicknameText

            myName.nickname = editText.text.toString()
            editText.visibility = View.GONE
            view.visibility = View.GONE
            nicknameTextView.visibility = View.VISIBLE
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

            
        }
    }
}