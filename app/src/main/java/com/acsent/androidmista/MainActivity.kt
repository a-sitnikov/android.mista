package com.acsent.androidmista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.acsent.androidmista.topicslist.ListViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this);
        val adapter = ListViewAdapter(API.getTopicsList())
        recyclerView.adapter = adapter

        swipeRefreshLayout.setOnRefreshListener{
            swipeRefreshLayout.isRefreshing = false
            val newList = API.getTopicsList()
            (recyclerView.adapter as ListViewAdapter).updateData(newList);
        }
    }

}