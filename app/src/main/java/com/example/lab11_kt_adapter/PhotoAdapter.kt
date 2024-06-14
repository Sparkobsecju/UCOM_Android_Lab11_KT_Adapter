package com.example.lab11_kt_adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Gallery
import android.widget.ImageView

class PhotoAdapter(val context: Activity): BaseAdapter() {

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
        R.drawable.image5
    )
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
        val image = ImageView(context)
        image.setImageResource(IMAGES[position])
        image.layoutParams = Gallery.LayoutParams(300, 300)
        image.scaleType = ImageView.ScaleType.FIT_XY
        return image
    }
}