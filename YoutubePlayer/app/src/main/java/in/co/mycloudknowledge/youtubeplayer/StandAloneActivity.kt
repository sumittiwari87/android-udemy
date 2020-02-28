package `in`.co.mycloudknowledge.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*

class StandAloneActivity :AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)
        buttonPlayPlaylist.setOnClickListener(this)
        buttonPlayVideo.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = when(v.id){
            R.id.buttonPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(this, getString(R.string.YOUTUBE_API_KEY),
                YOUTUBE_VIDEO_ID,0,true,false)
            R.id.buttonPlayPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(this,getString(R.string.YOUTUBE_API_KEY),
                YOUTUBE_PLAYLIST,0,0,true,true)
            else -> throw IllegalArgumentException("Undefined Button")
        }
        startActivity(intent)
    }
}