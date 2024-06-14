package com.example.lab11_kt_adapter

import android.app.ListActivity
import android.os.Bundle

class Adapter3: ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = PhotoFileAdapter(this)
    }
}