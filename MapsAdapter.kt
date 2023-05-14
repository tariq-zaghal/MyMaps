package com.example.mymaps

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mymaps.models.UserMap

private const val TAG = "MapsAdapter"
// " : " means inherits
class MapsAdapter(val context: Context, val userMaps:List<UserMap>, val onClickListener: OnCLickListener):RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    //informs main the a position is clicked
    interface OnCLickListener{
        fun onItemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view =  LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener {
            Log.i(TAG,"tapped on position $position")
            onClickListener.onItemClick(position)
        }

        val textViewTitle =holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text = userMap.title

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


}