package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var noteDatabase:NoteDatabase?=null

    lateinit var layoutManager: LinearLayoutManager
    lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onRestart() {
        super.onRestart()
        getAllNotes()

    }
    private fun getAllNotes() {
        GlobalScope.launch {
            val list: List<NoteModel>? =
                noteDatabase?.noteDao()?.getAllNote()
            runOnUiThread {
                showAllNotes(list)
            }
        }
    }
    private fun showAllNotes(list: List<NoteModel>?) {
        noteAdapter.setListOfNotes(list)
    }
}
