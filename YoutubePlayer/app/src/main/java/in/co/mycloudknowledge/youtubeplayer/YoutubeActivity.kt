package `in`.co.mycloudknowledge.youtubeplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

const val YOUTUBE_VIDEO_ID="eN6AYHAT8UM"
const val YOUTUBE_PLAYLIST="FL_VNnSmG8c9IONmttDjsDxg"

class YoutubeActivity : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener {

    val TAG ="YoutubeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = layoutInflater.inflate(R.layout.activity_youtube,null) as ConstraintLayout
        setContentView(layout)
        val playerView = YouTubePlayerView(this)
        playerView.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT
        )
        layout.addView(playerView)
        playerView.initialize(getString(R.string.YOUTUBE_API_KEY),this)

    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        Log.d(TAG,"onInitializationSuccess")
        Log.d(TAG,"onInitializationSuccess: provider is $p0")
        Log.d(TAG,"onInitializationSuccess: player is $p1")

        p1?.setPlaybackEventListener(playbackEventListener)
        p1?.setPlayerStateChangeListener(playerStateChangeListener)
        if(!p2){
            p1?.loadVideo(YOUTUBE_VIDEO_ID)
        }else{
            p1?.play()
        }
    }

    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        val REQUEST_CODE=0
        if(p1?.isUserRecoverableError==true){
            p1?.getErrorDialog(this,REQUEST_CODE).show()
        }else{
            Toast.makeText(this,"There was an error $p1",Toast.LENGTH_LONG).show()
        }
        Log.d(TAG,"onInitializationFailure")
    }

    private val playbackEventListener = object : YouTubePlayer.PlaybackEventListener{
        override fun onSeekTo(p0: Int) {
        }

        override fun onBuffering(p0: Boolean) {
        }

        override fun onPlaying() {
            Toast.makeText(this@YoutubeActivity, "Good: Video is playing OK ", Toast.LENGTH_LONG).show()
        }

        override fun onStopped() {
        }

        override fun onPaused() {
            Toast.makeText(this@YoutubeActivity, "Opa: Video is Paused OK ", Toast.LENGTH_LONG).show()
        }
    }

    private val playerStateChangeListener = object : YouTubePlayer.PlayerStateChangeListener{
        override fun onAdStarted() {
            Toast.makeText(this@YoutubeActivity, "onAdStarted: Make the owner rich pls ", Toast.LENGTH_LONG).show()
        }

        override fun onLoading() {
        }

        override fun onVideoStarted() {
            Toast.makeText(this@YoutubeActivity, "onVideoStarted: Video is Started ", Toast.LENGTH_LONG).show()
        }

        override fun onLoaded(p0: String?) {
        }

        override fun onVideoEnded() {
            Toast.makeText(this@YoutubeActivity, "onVideoEnded: Congratulation for watching Video ", Toast.LENGTH_LONG).show()
        }

        override fun onError(p0: YouTubePlayer.ErrorReason?) {
        }
    }
}
