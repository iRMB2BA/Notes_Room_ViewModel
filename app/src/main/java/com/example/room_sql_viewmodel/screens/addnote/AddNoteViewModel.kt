package com.example.room_sql_viewmodel.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room_sql_viewmodel.REPOSITORY
import com.example.room_sql_viewmodel.model.NoteModel
import io.reactivex.internal.operators.single.SingleDoOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel(){

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }
}