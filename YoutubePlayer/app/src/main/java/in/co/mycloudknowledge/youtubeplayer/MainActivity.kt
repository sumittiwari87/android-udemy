package `in`.co.mycloudknowledge.youtubeplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSingleVideo.setOnClickListener(this)
        buttonSubMenu.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var intent = when(v.id){
            R.id.buttonSingleVideo -> Intent(this, YoutubeActivity::class.java)
            R.id.buttonSubMenu -> Intent(this, StandAloneActivity::class.java)
            else -> throw IllegalArgumentException("Button not clicked ")
        }
        startActivity(intent)
    }
}
