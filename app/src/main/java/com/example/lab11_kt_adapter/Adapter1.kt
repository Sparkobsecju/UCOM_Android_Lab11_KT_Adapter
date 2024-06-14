package com.example.lab11_kt_adapter

import android.app.ListActivity
import android.os.Bundle
import android.widget.ArrayAdapter

import android.app.ListActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter

class Adapter1 : ListActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val incomePlaceHolder = resources.getStringArray(R.array.income_placeholder)
        listAdapter = ArrayAdapter(this, R.layout.income_item, incomePlaceHolder)
        listView.setOnItemClickListener(Adapter1ItemClickAction(this))
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        val i: AdapterContextMenuInfo = menuInfo as AdapterContextMenuInfo
        menu!!.add("menu1")
        menu.setHeaderTitle("第${i.position}個項目長按後的本文選單")
        super.onCreateContextMenu(menu, v, menuInfo)
    }
}