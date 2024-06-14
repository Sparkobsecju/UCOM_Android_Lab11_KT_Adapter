package com.example.lab11_kt_adapter

import android.app.Activity
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class PhotoFileAdapter(val context: Activity): BaseAdapter() {
    companion object {
        private val IMAGES = intArrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
        )
    }
    override fun getCount(): Int {
        return IMAGES.size
    }

    override fun getItem(position: Int): Any {
        return IMAGES[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val currentView = inflater.inflate(R.layout.list_item, null, false)
        val bd = context.resources.getDrawable(IMAGES[position]) as BitmapDrawable
        val result = "維度是${bd.bitmap.width}x${bd.bitmap.height}"
        val subTextView1 = currentView.findViewById<TextView>(R.id.textView1)
        val subImageView1 = currentView.findViewById<ImageView>(R.id.imageView1)
        subTextView1.text = result
        subImageView1.setImageResource(IMAGES[position])
        return currentView
    }
}