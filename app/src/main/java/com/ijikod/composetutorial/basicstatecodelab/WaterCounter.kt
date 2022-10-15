package com.ijikod.composetutorial.basicstatecodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.R

@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    val count = 0
    Text(text = stringResource(id = R.string.glasses_taken_text, count),
    modifier = modifier.padding(16.dp))
}
