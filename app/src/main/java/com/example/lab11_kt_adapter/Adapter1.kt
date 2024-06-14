package com.example.lab11_kt_adapter

import android.app.ListActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class Adapter1: ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val incomePlaceHolder = resources.getStringArray(R.array.income_placeholder)
        listAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, incomePlaceHolder)
    }
}