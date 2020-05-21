package com.mawdoo3.databindingwithrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Model>()
        list.add(Model("A"))
        list.add(Model("B"))

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = GenericRecyclerViewAdapter(list, R.layout.list_item)
        myRecycler.layoutManager = layoutManager

        myRecycler.adapter = adapter

    }
}
