package com.ijikod.composetutorial.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.R

@Composable
fun StatefulWaterCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessWaterCounter(count = count, onIncrement = { count++ }, modifier = modifier)
}

@Composable
fun StatelessWaterCounter(count:Int, onIncrement: () -> Unit, modifier: Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = stringResource(id = R.string.glasses_taken_text, count))
        }

        Button(onClick = onIncrement) {
            Text(text = stringResource(id = R.string.add_one_btn_txt))
        }
    }
}
