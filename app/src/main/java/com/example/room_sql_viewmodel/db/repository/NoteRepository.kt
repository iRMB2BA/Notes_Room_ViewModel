package com.example.room_sql_viewmodel.db.repository

import androidx.lifecycle.LiveData
import com.example.room_sql_viewmodel.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess:() -> Unit)
}