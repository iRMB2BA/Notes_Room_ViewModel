package com.example.room_sql_viewmodel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room_sql_viewmodel.R
import com.example.room_sql_viewmodel.model.NoteModel
import com.example.room_sql_viewmodel.screens.start.StartFragment
import kotlinx.android.synthetic.main.item_card_layout.view.*

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    var ListNote = emptyList<NoteModel>()



    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.item_card_title.text = ListNote[position].title
    }

    override fun getItemCount(): Int {
        return ListNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        ListNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(ListNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}