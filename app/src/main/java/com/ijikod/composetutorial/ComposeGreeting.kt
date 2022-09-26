package com.ijikod.composetutorial

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeGreeting {

    @Composable
    fun MyApp(names: List<String> = listOf("World", "Compose")) {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Column(modifier = Modifier.padding(vertical = 4.dp)) {
                for (name in names) {
                    Greeting(name = name)
                }
            }
        }
    }

    @Composable
    private fun Greeting(name: String) {
        val extended = remember { mutableStateOf(false) }

        val extraPadding  = if (extended.value) 48.dp else 0.dp

        Surface(color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Row(modifier = Modifier.padding(all = 24.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "Hello,")
                    Text(text = name)
                }

                OutlinedButton( modifier = Modifier.padding(bottom = extraPadding),
                    onClick = { extended.value = !extended.value }
                )
                {
                    Text( if(extended.value)  "Show less" else "Show more" )
                }
            }
        }

    }

    @Preview(showBackground = true, name = "Text Preview", widthDp = 320)
    @Composable
    fun DefaultPreview() {
        ComposeTutorialTheme { MyApp() }
    }
}