package com.itis2019.lecturerecorder.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.itis2019.lecturerecorder.utils.DateConverter
import java.util.Date

@Entity(tableName = "folder_data")
data class Folder(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    @TypeConverters(DateConverter::class)
    val creationDate: Date,
    val background: Int
)
