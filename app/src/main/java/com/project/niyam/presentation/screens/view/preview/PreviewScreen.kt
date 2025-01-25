package com.project.niyam.presentation.screens.view.preview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.niyam.domain.services.StopWatchService
import com.project.niyam.domain.services.StopwatchState
import com.project.niyam.domain.services.StrictTaskService
import com.project.niyam.domain.services.StrictTaskState
import com.project.niyam.presentation.screens.viewmodels.preview.PreviewScreenViewModel

@Composable
fun PreviewScreen(
    stopWatchService: StrictTaskService,
    viewModel: PreviewScreenViewModel = hiltViewModel(),
    id: Int,
) {
    val context = LocalContext.current
//    val info = stopWatchService.taskMap.value
    val hours: String = stopWatchService.hours.value
    val minutes = stopWatchService.minutes.value
    val seconds = stopWatchService.seconds.value
    val currentState by stopWatchService.currentState
    val uiState by viewModel.uiState
//    val subTasks = uiState.subTasks
//    val currentIndex = uiState.currentIndex
//    if (uiState.isEnabled) {
//        viewModel.getStrictTask(id)
//        viewModel.updateEnable()
//    }

    if (currentState == StrictTaskState.COMPLETED) {
        Text("Task Completed")
    }
    viewModel.updateID(id, context)
//    viewModel.updateIsStrict(isStrict, context)
//    LaunchedEffect(key1 = id) {
//        viewModel.getStrictTask(id)
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            if (uiState.currentIndex != 0) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable {
                            viewModel.decreaseIndex()
                        },
                )
            }
            Column {
                Text(uiState.subTasks[uiState.currentIndex].subTaskName)
                Text(
                    modifier = Modifier.padding(top = 12.dp),
                    text = uiState.subTasks[uiState.currentIndex].subTaskDescription,
                )
            }
            if (uiState.currentIndex != uiState.subTasks.size - 1) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable {
                            viewModel.increaseIndex()
                        },
                )
            }
        }
        Button(onClick = {
            viewModel.subTaskDone()
        }, enabled = !uiState.subTasks[uiState.currentIndex].isCompleted) {
            Text(
                text = "Done",
                color = if (uiState.subTasks[uiState.currentIndex].isCompleted) Color.Green else Color.Black,
            )
        }

        Column(
            modifier = Modifier.weight(weight = 9f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
//            AnimatedContent(targetState = hours, transitionSpec = { addAnimation() }) {
            Text(
                text = hours,
                style = TextStyle(
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (hours == "00") Color.White else Blue,
                ),
            )
//            }
//            AnimatedContent(targetState = minutes, transitionSpec = { addAnimation() }) {
            Text(
                text = minutes,
                style = TextStyle(
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (minutes == "00") Color.White else Blue,
                ),
            )
//            }
//            AnimatedContent(targetState = seconds, transitionSpec = { addAnimation() }) {
            Text(
                text = seconds,
                style = TextStyle(
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (seconds == "00") Color.White else Blue,
                ),
            )
//            }
        }
    }
}


