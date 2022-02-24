package com.tanay.louisample.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface DictionaryDao {
    @Query("SELECT * FROM dictionary")
    fun getAll(): Flow<List<DictionaryEntity>>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWord(entity: DictionaryEntity)

    @Delete
    fun deleteWord(entity: DictionaryEntity)

    @Query("DELETE FROM dictionary")
    fun deleteAll()
}