package com.tanay.louisample.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DictionaryViewModel(context: Application): AndroidViewModel(context) {
    private val database = AppDatabase.getDatabase(context)
    private val dictionaryDao = database.dictionaryDao()

    private fun backgroundTask(task: () -> Unit){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                task()
            }
        }
    }

    fun getAllWords() = dictionaryDao.getAll()?.asLiveData()

    fun insertWord(word: DictionaryEntity) {
        backgroundTask {
            dictionaryDao.insertWord(word)
        }
    }

    fun deleteWord(word: DictionaryEntity) {
        backgroundTask {
            dictionaryDao.deleteWord(word)
        }
    }

    fun deleteAll() {
        backgroundTask {
            dictionaryDao.deleteAll()
        }
    }


}