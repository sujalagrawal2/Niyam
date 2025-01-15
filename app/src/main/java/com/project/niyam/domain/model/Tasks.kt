package com.project.niyam.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.project.niyam.data.typeConverters.SubTaskConverter

@Entity
@TypeConverters(SubTaskConverter::class)
data class Tasks(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val taskName: String = "",
    var taskDescription: String = "",
    val hours: String = "",
    val days: Int = 1,
    val isCompleted: Boolean = false,
    val subTasks: List<SubTasks> = listOf(),
    val date: String = "",
)
