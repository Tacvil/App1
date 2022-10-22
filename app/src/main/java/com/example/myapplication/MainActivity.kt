package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
@SuppressLint("StaticFieldLeak")
private lateinit var textView2: TextView
@SuppressLint("StaticFieldLeak")
private lateinit var editText1: EditText
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView2 = findViewById(R.id.textView2)
        editText1 = findViewById(R.id.editText1)
    }
    fun showMe (view: View) {
        val countString = editText1.getText().toString()
        val string: String = "Привет, $countString!"
        textView2.text = string
    }
}