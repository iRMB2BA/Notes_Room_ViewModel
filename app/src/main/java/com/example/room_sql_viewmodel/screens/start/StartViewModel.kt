package com.example.room_sql_viewmodel.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.room_sql_viewmodel.REPOSITORY
import com.example.room_sql_viewmodel.db.NoteDataBase
import com.example.room_sql_viewmodel.db.repository.NoteRealization
import com.example.room_sql_viewmodel.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application){
    val context= application


    fun initDatabase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }
    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}