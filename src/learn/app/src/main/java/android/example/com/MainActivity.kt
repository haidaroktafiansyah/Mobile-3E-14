package android.example.com

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val textView: TextView = findViewById<TextView>(R.id.result_text)
        textView.text = "Dice Rolled !"
        rollButton.setOnClickListener { rollDice() }
        add_button.setOnClickListener { add1() }
    }

    private fun rollDice(){
        Toast.makeText(this, "rolled", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        result_text.text = randomInt.toString()
    }

    private fun add1(){
        val textView: TextView = findViewById<TextView>(R.id.result_text)
        var res = textView.text.toString()
        if(res.equals("Dice Rolled !")){
            Toast.makeText(this, "value initialized", Toast.LENGTH_SHORT).show()
            textView.text = "1";
        }else if(res.equals("6")){
            Toast.makeText(this, "value is max", Toast.LENGTH_SHORT).show()
            textView.text = "6"
        }else{
            Toast.makeText(this, "added 1", Toast.LENGTH_SHORT).show()
            res = (res.toInt()+1).toString()
            textView.text = res
        }
    }
}