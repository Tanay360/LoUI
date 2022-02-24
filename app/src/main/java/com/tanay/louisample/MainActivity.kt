package com.tanay.louisample

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.tanay.loui.*
import com.tanay.loui.components.*
import com.tanay.loui.components.lazylist.LazyList
import com.tanay.loui.views.AlertDialog
import com.tanay.louisample.db.DictionaryEntity
import com.tanay.louisample.db.DictionaryViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: DictionaryViewModel by viewModels()

    private lateinit var lazyList: LazyList<DictionaryEntity, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createView())
        viewModel.getAllWords()?.observe(this) {
            it?.let { list ->
                lazyList.changeItems(list)
            }
        }
    }

    private fun createView(): View {
        return Scaffold(
            topBar = {
                TopAppBar(title = "Dictionary")
            },
            menuOptions = arrayOf(
                MenuItem(
                    title = "Delete All",
                    icon = Icons.Delete,
                    priority = MenuPriority.IF_ROOM
                ) {
                    viewModel.deleteAll()
                }
            ),
            floatingActionButton = {
                FloatingActionButton(icon = Icons.Add, onClick = {
                    showCreateDialog()
                })
            }
        ) {
            LazyList<DictionaryEntity, String>(
                items = listOf(),
                key = { it.word },
                bind = { lazyList = it })
            { wordEntity ->
                Card(borderRadius = 8.dp, rippleColor = ColorStateList.valueOf(Color.LTGRAY)) {
                    it.onLongClick {
                        viewModel.deleteWord(wordEntity)
                    }
                    Column {
                        Text(text = "Word: ${wordEntity.word}", textSize = 8.sp)
                        Text(text = "Meaning: ${wordEntity.meaning}", textSize = 8.sp)
                        Divider()
                    }
                }
            }
        }
    }

    private var alertDialog: AlertDialog? = null

    private var word: String = ""
    private var meaning = ""

    private fun getDialog(): AlertDialog {
        return alertDialog ?: run {
            AlertDialog(
                title = {
                    Text(text = "Create new entry")
                },
                content = {
                    TextField(label = "Word", value = word, onTextChanged = {
                        it?.let { word = it.toString() }
                    }).apply {
                        onDismissed {
                            setText("")
                        }
                    }

                    Component(
                        view = View(this@MainActivity)
                    ) {
                        size(8.dp, Dp.FILL)
                    }

                    TextField(label = "Meaning", value = meaning, onTextChanged = {
                        it?.let { meaning = it.toString() }
                    }).apply {
                        onDismissed {
                            setText("")
                        }
                    }
                },
                buttons = {
                    Button(
                        text = "Cancel",
                        onClick = {
                            dismissDialog()
                        }
                    )
                    Component(
                        view = View(this@MainActivity)
                    ) {
                        size(8.dp, 8.dp)
                    }
                    Button(
                        text = "Create",
                        onClick = {
                            if (word.isNotEmpty() && word.isNotBlank() && meaning.isNotEmpty() && meaning.isNotBlank()) {
                                viewModel.insertWord(DictionaryEntity(word, meaning))
                                dismissDialog()
                            } else {
                                Toast.makeText(
                                    this@MainActivity,
                                    "All fields are required",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )
                    onDismissed {
                        word = ""
                        meaning = ""
                    }
                }
            ).also {
                alertDialog = it
            }
        }
    }

    private fun showCreateDialog() {
        getDialog().show()
    }
}