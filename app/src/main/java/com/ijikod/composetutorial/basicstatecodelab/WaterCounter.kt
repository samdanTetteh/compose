package com.ijikod.composetutorial.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(taskName = "Have you taken your 15 minute walk today?",
                onClose = { showTask = false})
            }
            Text(text = stringResource(id = R.string.glasses_taken_text, count))
        }

        Row(modifier = modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, enabled = count < 10) {
                Text(text = stringResource(R.string.add_one_btn_txt))
            }

            Button(onClick = { count = 0 }, modifier = modifier.padding(start = 8.dp)) {
                Text(text = stringResource(id = R.string.clear_water_count_txt))
            }
        }

    }

}
