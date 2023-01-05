package com.ijikod.composetutorial.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ijikod.composetutorial.vm.WellnessViewModel

@Composable
fun WellnessScreen(modifier: Modifier = Modifier,
                   wellnessViewModel: WellnessViewModel = viewModel()){
    Column (modifier = modifier) {
        StatefulWaterCounter()

        WellnessTasksList(list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.removeTask(task) })
    }
}