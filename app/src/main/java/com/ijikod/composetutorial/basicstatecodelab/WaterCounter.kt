package com.ijikod.composetutorial.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.R

@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    var count by remember { mutableStateOf(0) }
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = stringResource(id = R.string.glasses_taken_text, count))
        }

        Button(onClick = { count++ }, modifier = modifier.padding(top = 8.dp), enabled = count < 10) {
               Text(text = stringResource(R.string.add_one_btn_txt))
        }
    }

}
