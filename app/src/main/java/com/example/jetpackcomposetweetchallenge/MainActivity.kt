package com.example.jetpackcomposetweetchallenge

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetweetchallenge.ui.theme.JetpackComposeTweetChallengeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTweetChallengeTheme {
                val window: Window = this.window
                window.statusBarColor = Color(0xFF1B2936).toArgb()
                window.navigationBarColor = Color(0xFF1B2936).toArgb()
                Surface(
                    modifier = Modifier.fillMaxSize().padding(),
                    color = Color(0xFF1B2936)
                ) {
                    var tweetInfo = Tweet(
                        avatar = R.drawable.profile,
                        nickName = "Jhonatan",
                        atSign = "@JhonatanLS",
                        creationDate = "4h",
                        tweetText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sit amet ex ac ex porta varius ac a eros. Suspendisse tincidunt commodo auctor. Proin malesuada malesuada est, nec aliquet ex tristique non.",
                        image = R.drawable.profile,

                    )
                    TweetComponent(tweet = tweetInfo)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTweetChallengeTheme {
        Greeting("Android")
    }
}