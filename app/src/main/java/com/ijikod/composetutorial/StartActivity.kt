package com.ijikod.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.ui.theme.ComposeTutorialTheme

class StartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                MyStartScreen()
            }
        }
    }



    @Composable
    private fun MyStartScreen(){
        var showStartScreen by remember { mutableStateOf(true) }

        Surface {
            Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
                
                Text(text = "Welcome to Basics Codelab")
                Button(modifier = Modifier.padding(all = 24.dp),
                    onClick = { showStartScreen =  false }) {
                    Text(text = "Continue")
                }
            }
        }

    }

    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun StartPreview(){
        ComposeTutorialTheme {
            MyStartScreen()
        }
    }
}