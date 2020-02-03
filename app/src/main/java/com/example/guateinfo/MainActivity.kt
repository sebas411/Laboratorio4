package com.example.guateinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var editNombre: EditText
    lateinit var textNombre: TextView
    lateinit var showNombre: TextView
    private var set=true
    private var texto=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editNombre=findViewById(R.id.editText2)
        textNombre=findViewById(R.id.textView)
        showNombre=findViewById(R.id.textView2)
        showNombre.visibility = View.INVISIBLE
        val starButton:ImageButton=findViewById(R.id.starButton)
        starButton.setOnClickListener{
            setText()
        }

    }
    private fun setText() {
        if (set) {
            showNombre.setText(editNombre.getText())
            editNombre.visibility = View.INVISIBLE
            textNombre.visibility = View.INVISIBLE
            showNombre.visibility = View.VISIBLE
        }else{
            editNombre.visibility = View.VISIBLE
            textNombre.visibility = View.VISIBLE
            showNombre.visibility = View.INVISIBLE
        }
        set=!set
    }
}
