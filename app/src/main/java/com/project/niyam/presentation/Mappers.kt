package com.project.niyam.presentation

import android.util.Log
import com.project.niyam.domain.model.StrictTasks
import com.project.niyam.domain.model.SubTasks
import com.project.niyam.domain.model.Tasks
import com.project.niyam.presentation.screens.viewmodels.preview.PreviewScreenUIState
import com.project.niyam.presentation.screens.viewmodels.preview.StrictPreviewScreenUIState
import com.project.niyam.presentation.screens.viewmodels.tasks.CreateStrictTaskUiState
import com.project.niyam.presentation.screens.viewmodels.tasks.CreateSubTaskUiState
import com.project.niyam.presentation.screens.viewmodels.tasks.CreateTaskUiState

fun StrictTasks.toStrictPreviewScreenUIState(currentIndex: Int): StrictPreviewScreenUIState {
    Log.i("uiState", "Preview mapper called")
    return StrictPreviewScreenUIState(
        id = this.id,
        taskName = this.taskName,
        taskDescription = this.taskDescription,
        startTime = this.startTime,
        endTime = this.endTime,
        isCompleted = this.isCompleted,
        subTasks = this.subTasks,
        date = this.date,
        currentIndex = currentIndex,
    )
}

fun StrictPreviewScreenUIState.toStrictTasks(): StrictTasks {
    Log.i("uiState", "Preview mapper of task called")
    return StrictTasks(
        id = this.id,
        taskName = this.taskName,
        taskDescription = this.taskDescription,
        startTime = this.startTime,
        endTime = this.endTime,
        isCompleted = this.isCompleted,
        subTasks = this.subTasks,
        date = this.date,
    )
}

fun Tasks.toPreviewScreenUIState(currentIndex: Int): PreviewScreenUIState {
    Log.i("uiState", "Preview mapper called")
    return PreviewScreenUIState(
        id = this.id,
        taskName = this.taskName,
        taskDescription = this.taskDescription,
        startDate = this.startDate,
        endDate = this.endDate,
        isCompleted = this.isCompleted,
        subTasks = this.subTasks,
        currentIndex = currentIndex,
        minutesRemaining = this.minutesRemaining
    )
}

fun PreviewScreenUIState.toTasks(): Tasks {
    Log.i("uiState", "Preview mapper of task called")
    return Tasks(
        id = this.id,
        taskName = this.taskName,
        taskDescription = this.taskDescription,
        startDate = this.startDate,
        endDate = this.endDate,
        isCompleted = this.isCompleted,
        subTasks = this.subTasks,
        minutesRemaining = this.minutesRemaining,
    )
}

fun CreateStrictTaskUiState.toStrictTasks(date: String = ""): StrictTasks {
    return StrictTasks(
        taskName = this.name,
        taskDescription = this.description,
        startTime = this.startTime,
        endTime = this.endTime,
        subTasks = this.subTasks.map { it.toSubTasks() },
        date = date
    )
}

// Mapper for StrictTasks to CreateTaskUiState
//fun StrictTasks.toCreateTaskUiState(): CreateTaskUiState {
//    return CreateTaskUiState(
//        name = this.taskName,
//        description = this.taskDescription,
//        startTime = this.startTime,
//        endTime = this.endTime,
//        subTasks = this.subTasks.map { it.toCreateSubTaskUiState() }
//    )
//}

// Mapper for CreateSubTaskUiState to SubTasks
fun CreateSubTaskUiState.toSubTasks(): SubTasks {
    return SubTasks(
        subTaskName = this.subTaskName,
        subTaskDescription = this.subTaskDescription
    )
}

// Mapper for SubTasks to CreateSubTaskUiState
fun SubTasks.toCreateSubTaskUiState(): CreateSubTaskUiState {
    return CreateSubTaskUiState(
        subTaskName = this.subTaskName,
        subTaskDescription = this.subTaskDescription
    )
}

fun CreateTaskUiState.toTasks(date: String = ""): Tasks {

    return Tasks(
        taskName = this.name,
        taskDescription = this.description,
        startDate = this.startDate,
        endDate = this.endDate,
        subTasks = this.subTasks.map { it.toSubTasks() },
        minutesRemaining = this.minutesRemaining
    )

}
