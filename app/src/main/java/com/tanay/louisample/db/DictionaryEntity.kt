package com.tanay.louisample.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dictionary")
data class DictionaryEntity(
    @PrimaryKey val word: String,
    val meaning: String
)