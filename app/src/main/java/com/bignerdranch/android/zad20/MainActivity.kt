package com.bignerdranch.android.zad20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    public var APP_PREFERENS = "mysettings";
    public var PREF_NAMEE = "Name";
    lateinit var settings: SharedPreferences
    private  lateinit var nameBox: EditText
    lateinit var nameView: TextView

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings = getSharedPreferences(PREF_NAMEE, MODE_PRIVATE);
    }
    fun saveName(view: View)
    {
        nameBox = findViewById(R.id.editText);
        var name = nameBox.text.toString();
        nameBox.isInEditMode.not();
        var prefEditor = settings.edit();
        prefEditor.putString(PREF_NAMEE, name);
        prefEditor.apply();
    }
    fun getName(view: View)
    {
        nameView = findViewById(R.id.editText)
        var name = settings.getString(PREF_NAMEE,"не определено")
        nameView.text = name
        nameBox = findViewById(R.id.textView);
        nameBox.setText(name)
    }
}