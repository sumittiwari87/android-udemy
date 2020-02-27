package `in`.co.rssfeedapp

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.URL

class MainActivity : AppCompatActivity() {

    private var url: String? = null
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        url = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=25/xml"
        val downloadData = DownloadData()
        Log.d(TAG,"Async Task initiated, let's execute it with url $url")
        downloadData.execute(url)
    }
    companion object{
        private class DownloadData : AsyncTask<String, Void, String>(){
            private val TAG ="DownloadData"
            override fun onPostExecute(result: String?) {
                Log.d(TAG,"onPostExecute")
                super.onPostExecute(result)
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG,"doInBackground : start with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if(rssFeed.isEmpty()){
                    Log.d(TAG,"doInBackground : Error in downloading data ")
                }
                Log.d(TAG,"doInBackground $rssFeed")
                return rssFeed
            }

            private fun downloadXML(url:String?): String {
                return URL(url).readText()
            }
        }
    }

}
