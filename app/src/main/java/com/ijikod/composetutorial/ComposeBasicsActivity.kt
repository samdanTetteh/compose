package com.ijikod.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeBasicsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme { MyApp() }
        }
    }


    @Composable
    private fun MyApp(){
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Greeting(name = "Android")
        }
    }

    @Composable
    private fun Greeting(name: String){
        Surface(color = MaterialTheme.colors.primary) {
            Text(text = "Hello $name", modifier = Modifier.padding(24.dp))
        }

    }

    @Preview(showBackground = true, name = "Text Preview")
    @Composable
    fun DefaultPreview() {
        ComposeTutorialTheme { MyApp() }
    }
}