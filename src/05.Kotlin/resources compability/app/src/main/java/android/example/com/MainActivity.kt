package android.example.com

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    private lateinit var diceImage: ImageView
    private lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
        rollButton.setOnClickListener { rollDice() }
//        add_button.setOnClickListener { add1() }
    }

    private fun rollDice() {
        Toast.makeText(this, "rolled", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        val randomInt2 = (1..6).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
    }

//    private fun add1(){
//        val textView: TextView = findViewById<TextView>(R.id.result_text)
//        var res = textView.text.toString()
//        if(res.equals("Dice Rolled !")){
//            Toast.makeText(this, "value initialized", Toast.LENGTH_SHORT).show()
//            textView.text = "1";
//        }else if(res.equals("6")){
//            Toast.makeText(this, "value is max", Toast.LENGTH_SHORT).show()
//            textView.text = "6"
//        }else{
//            Toast.makeText(this, "added 1", Toast.LENGTH_SHORT).show()
//            res = (res.toInt()+1).toString()
//            textView.text = res
//        }
//    }
}