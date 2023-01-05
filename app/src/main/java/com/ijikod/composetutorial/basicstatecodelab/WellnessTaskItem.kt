package com.ijikod.composetutorial.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ijikod.composetutorial.R
import com.ijikod.composetutorial.data.WellnessTask
import com.ijikod.composetutorial.data.getWellnessTasks

@Composable
fun WellnessTaskItem(taskName: String,
                     modifier: Modifier = Modifier,
                     onClose: () -> Unit,
                     checked: Boolean,
                     onItemChecked: (Boolean) -> Unit) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(text = taskName, modifier = Modifier
            .weight(1f)
            .padding(start = 16.dp))

        Checkbox(checked = checked, onCheckedChange = onItemChecked)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = stringResource(R.string.close_task_item))
        }
    }
}


@Composable
fun WellnessTaskItem(taskName: String, onCloseTask: () -> Unit, modifier: Modifier = Modifier){
    var checkedSate by rememberSaveable { mutableStateOf(false) }

    WellnessTaskItem(taskName = taskName,
        onClose = onCloseTask,
        checked = checkedSate,
        onItemChecked = {
            checkedSate = it
        },
    modifier = modifier)
}


@Composable
fun WellnessTasksList(
    list: List<WellnessTask> = remember { getWellnessTasks() },
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,) {
    LazyColumn(modifier = modifier) {
        items(list) { task ->
            WellnessTaskItem(taskName = task.label, onCloseTask = {
                onCloseTask(task)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultView(){
    WellnessTaskItem(taskName = "Sam", onClose = {}, checked = true, onItemChecked = {})
}


@Preview(showBackground = true)
@Composable
fun WellnessTaskListPreview(){
    WellnessTasksList(onCloseTask = {})
}