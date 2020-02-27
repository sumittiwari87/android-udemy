package `in`.co.buttoncounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TEXT_CONTENTS"
class MainActivity : AppCompatActivity() {

    private var numTimesClicked =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG,"onCreate Calling !")
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

    override fun onStart() {
        Log.d(TAG,"onStart Calling !")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(TAG,"onRestart Calling !")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG,"onPause Calling !")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d(TAG,"onDestroy Calling !")
        super.onDestroy()
    }

    override fun onStop() {
        Log.d(TAG,"onStop Calling !")
        super.onStop()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.d(TAG,"onRestoreInstanceState Calling !")
        super.onRestoreInstanceState(savedInstanceState)
        var savedString = savedInstanceState?.getString(TEXT_CONTENTS)
        textView?.text =savedString
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(TAG,"onSaveInstanceState Calling !")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENTS,textView?.text.toString())
    }
}
