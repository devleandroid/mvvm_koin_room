package br.com.framework.mvvm.koin.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0,
    @ColumnInfo(name = "fullName")
    val userName: String,
    @ColumnInfo(name = "designation")
    val userDesignation: String
)
