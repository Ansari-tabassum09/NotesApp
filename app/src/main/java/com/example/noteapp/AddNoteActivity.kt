package com.example.noteapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.noteapp.databinding.ActivityAddNoteBinding
import com.example.noteapp.databinding.ActivityMainBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddNoteBinding
    private lateinit var db : NoteDatabaseHelper
    private var editMode: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)

        binding.saveButton.setOnClickListener{

            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val timestamp = if (editMode) {
                intent.getLongExtra("timestamp", System.currentTimeMillis())
            } else {
                System.currentTimeMillis()
            }
            val note = Note(0,title,content,timestamp)
            db.insertNote(note)
            finish()
        }

    }
}