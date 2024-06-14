package com.example.lab11_kt_adapter

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class Adapter2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adapter2)
        setupListView()
    }

    companion object {
        const val TITLE_FIELD = "titleField"
        const val DETAIL_FIELD = "detailField"
    }

    private fun setupListView() {
        val listView1 = findViewById<ListView>(R.id.listView1)
        val versions = resources.getStringArray(R.array.versions)
        val codeNames = resources.getStringArray(R.array.codes)

        val dataSource = ArrayList<HashMap<String, String>>()
        for (i in 0..2) {
            val record = HashMap<String, String>()
            record[TITLE_FIELD] = versions[i]
            record[DETAIL_FIELD] = codeNames[i]
            dataSource.add(record)
        }
        val simpleAdapter = SimpleAdapter(
            this, dataSource, R.layout.listview_item,
            arrayOf(TITLE_FIELD, DETAIL_FIELD), intArrayOf(R.id.titleField, R.id.detailField)
        )
        listView1.adapter = simpleAdapter
    }
}