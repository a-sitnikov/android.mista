package com.acsent.androidmista.topicslist

import android.graphics.Typeface
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.acsent.androidmista.R
import com.acsent.androidmista.TopicsListItemResponse
import androidx.lifecycle.ViewModel




class ListViewAdapter(private var list: Array<TopicsListItemResponse>): RecyclerView.Adapter<ListViewAdapter.ItemHolder>() {

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        var author:  TextView = view.findViewById(R.id.author)
        var section: TextView = view.findViewById(R.id.section)
        var text:    TextView = view.findViewById(R.id.text)
        var user:    TextView = view.findViewById(R.id.user)
        var count:   TextView = view.findViewById(R.id.count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder( LayoutInflater.from(parent.context).inflate(R.layout.activity_topics_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item = list[position]
        holder.author.text  = item.user0
        holder.user.text    = item.user
        holder.text.text    = item.text
        holder.section.text = item.sect1
        holder.count.text   = item.answ.toString()

        if (item.answ >= 100)
            holder.text.setTypeface(null, Typeface.BOLD)
        else
            holder.text.setTypeface(null, Typeface.NORMAL)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateData(newList: Array<TopicsListItemResponse>) {
        list = newList
        notifyDataSetChanged()
    }
}