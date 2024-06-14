package com.example.lab11_kt_adapter

import android.app.Activity
import android.view.View
import android.widget.AdapterView
import android.widget.Toast

class Adapter1ItemClickAction(val context: Activity) : AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(context, "第${position}個項目被點擊了", Toast.LENGTH_SHORT).show()
    }

}