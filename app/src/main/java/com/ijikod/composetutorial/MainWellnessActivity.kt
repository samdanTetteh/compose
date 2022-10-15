package com.ijikod.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ijikod.composetutorial.basicstatecodelab.WellnessScreen

class MainWellnessActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentScreen()
        }
    }


    @Composable
    private fun ContentScreen(modifier: Modifier = Modifier){
        Surface(modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
        ) {
            WellnessScreen()
        }
    }



    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview(){
        ContentScreen()
    }
}