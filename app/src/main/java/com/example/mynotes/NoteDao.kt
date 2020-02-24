package com.example.mynotes

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

//interface class
@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAllNote(): List<NoteModel>


    @Insert(onConflict = REPLACE)
    fun insertNote(note: NoteModel)

    @Delete
    fun deleteNote(note: NoteModel)

    @Query("UPDATE note SET title=:noteTitle,message =:noteMessage WHERE id =:noteId")
    fun updateNote(noteTitle:String, noteMessage:String, noteId:Long )

}