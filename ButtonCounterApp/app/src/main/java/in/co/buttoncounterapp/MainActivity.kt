package `in`.co.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var numTimesClicked =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText.setText("")
        textView?.text=""
        textView?.movementMethod = ScrollingMovementMethod()
        button?.setOnClickListener(object  : View.OnClickListener{
            override fun onClick(v: View?) {
                numTimesClicked+=1
                textView.append(editText.text)
                textView.append("\n")
                editText.setText("")
            }
        })

    }
}
