package com.example.lab11_kt_adapter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Gallery
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val g: Gallery = findViewById(R.id.gallery)
        g.adapter = PhotoAdapter(this)
        g.setOnItemClickListener(this)
        val spinner: Spinner = findViewById(R.id.spinner)
        val arrayAdapter = ArrayAdapter.createFromResource(
            this, R.array.codes,
            androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item
        )
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = SpinnerCallback()
    }

    inner class SpinnerCallback : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val message = resources.getStringArray(R.array.versions)[position]
            val t: TextView = findViewById<TextView>(R.id.textView)
            t.text = "你所選取的是:${message}"
        }
        override fun onNothingSelected(parent: AdapterView<*>?) {
            val t: TextView = findViewById<TextView>(R.id.textView)
            t.text = "沒有內容可選取"
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent()
        when (item.itemId) {
            R.id.lab1 -> intent.setClass(this, Adapter1::class.java)
            R.id.lab2 -> intent.setClass(this, Adapter2::class.java)
            R.id.lab3 -> intent.setClass(this, Adapter3::class.java)
        }
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, "第${1 + position}個圖被點擊了", Toast.LENGTH_SHORT).show()
    }
}

