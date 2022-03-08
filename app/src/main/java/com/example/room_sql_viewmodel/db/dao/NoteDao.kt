package com.example.room_sql_viewmodel.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.room_sql_viewmodel.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * from note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

}