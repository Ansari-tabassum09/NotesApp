package com.example.noteapp

import android.icu.text.CaseMap.Title

data class Note(val id:Int, val title: String, val content:String, val timestamp: Long)
