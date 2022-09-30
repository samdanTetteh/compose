package com.ijikod.composetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.ui.theme.ComposeTutorialTheme

class ComposeGreeting {

    @Composable
    fun MyApp(names: List<String> = List(1000) { "$it" }) {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
                LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
                    items(names) {
                        Card(backgroundColor = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
                            Greeting(name = it)
                        }
                    }
                }
        }
    }

    @Composable
    private fun Greeting(name: String) {
        var extended by remember { mutableStateOf(false) }

            Row(modifier = Modifier
                .padding(all = 24.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)) {
                    Text(text = "Hello,")
                    Text(text = name, style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    ))

                    if (extended) {
                        Text(text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4))
                    }
                }

                IconButton(onClick = { extended = !extended }) {
                    Icon(imageVector = if (extended) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (extended) stringResource(R.string.show_less)
                        else stringResource(R.string.show_more) )
                }
            }
    }

    @Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES, name = "Text Preview Night")
    @Preview(showBackground = true, name = "Text Preview", widthDp = 320)
    @Composable
    fun DefaultPreview() {
        ComposeTutorialTheme { MyApp() }
    }
}