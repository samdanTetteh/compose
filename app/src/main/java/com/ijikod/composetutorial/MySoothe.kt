package com.ijikod.composetutorial

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.ui.theme.ComposeTutorialTheme

class MySoothe {

    @Composable
    fun MyApp() {
        Surface(color = MaterialTheme.colors.background) {
            ContentScreen()
        }
    }


    @Composable
    private fun ContentScreen() {

    }


    @Composable
    private fun SearchBar(modifier: Modifier) {
        TextField(value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .heightIn(56.dp),
            colors =  TextFieldDefaults.textFieldColors(
                backgroundColor = MaterialTheme.colors.surface
            ),
        placeholder = {
            Text(text = "search")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = null)
        })
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun SearchBarPreview(){
        ComposeTutorialTheme { SearchBar(Modifier.padding(8.dp)) }
    }



    @Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, name = "My Soothe content")
    @Composable()
    fun DefaultPreview(){
        ComposeTutorialTheme { MyApp() }
    }

}