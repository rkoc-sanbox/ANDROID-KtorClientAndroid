package com.plcoding.ktorclientandroid

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.plcoding.ktorclientandroid.data.remote.PostsService
import com.plcoding.ktorclientandroid.data.remote.dto.PostResponse
import com.plcoding.ktorclientandroid.ui.theme.KtorClientAndroidTheme
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream


class MainActivity : ComponentActivity() {

    private val service = PostsService.create()



    fun playnow (audio: ByteArray) {
        val file = File.createTempFile("prefix", "suffix")
        file.deleteOnExit()
        val fos = FileOutputStream(file)
        fos.write(audio) //your bytes written in that temporary file

//        val mp = MediaPlayer()
//        mp.setDataSource("/mnt/sdcard/yourdirectory/youraudiofile.mp3")
//        mp.prepare()
//        mp.start()

        val mediaPlayer = MediaPlayer.create(this, Uri.fromFile(file))
        mediaPlayer.start()
        file.delete()
    }
//
//    fun pp(sndfil: String) {
//        val resourceIdentifier = resources.getIdentifier(sndfil, "raw", packageName)
//        val mp = MediaPlayer.create(this,resourceIdentifier)
//        mp.start()
//        return
//    }

//    val dachsunds = listOf(
//        R.raw.dachsund_0,
//        R.raw.dachsund_1,
//        R.raw.dachsund_2,
//        R.raw.dachsund_3,
//        // ...
//        R.raw.dachsund_10
//    )
//
//    val dachsund = dachsunds[dachsundIndex]
//    val mediaPlayer = MediaPlayer.create(context, dachsund).apply {
//        start()
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val audio = service.getPosts()
            playnow(audio)
        }

        setContent {
            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = emptyList()
                }
            )


            KtorClientAndroidTheme {
                Surface(color = MaterialTheme.colors.background) {
//                    LazyColumn {
//                        items(posts.value) {
//                            Column(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(16.dp)
//                            ) {
//                                Text(text = it.title, fontSize = 20.sp)
//                                Spacer(modifier = Modifier.height(4.dp))
//                                Text(text = it.body, fontSize = 14.sp)
//                            }
//                        }
//                    }
                }
            }
        }
    }
}