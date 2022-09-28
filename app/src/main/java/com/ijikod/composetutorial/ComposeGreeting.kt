package com.ijikod.composetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
                        Greeting(name = it)
                    }
                }
        }
    }

    @Composable
    private fun Greeting(name: String) {
        var extended by remember { mutableStateOf(false) }

        val extraPadding by animateDpAsState (
            if (extended) 48.dp else 0.dp,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )

        Surface(color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
            Row(modifier = Modifier.padding(all = 24.dp)) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))) {
                    Text(text = "Hello,")
                    Text(text = name, style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    ))
                }

                IconButton(onClick = { extended = !extended }) {
                    Icon(imageVector = if (extended) Icons.Filled.Expand else Icons.Filled.ExpandMore,
                        contentDescription = if (extended) "Show less" else "Show more" )
                }
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