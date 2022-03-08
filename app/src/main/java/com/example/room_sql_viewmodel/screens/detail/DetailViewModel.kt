package com.example.room_sql_viewmodel.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.room_sql_viewmodel.REPOSITORY
import com.example.room_sql_viewmodel.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
}