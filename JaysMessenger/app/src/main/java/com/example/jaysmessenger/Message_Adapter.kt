package com.example.jaysmessenger

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Message_Adapter(val context: Context, val messageList: ArrayList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    class sendViewHolder(item: View): RecyclerView.ViewHolder(item){

        var sendMessage: TextView = item.findViewById(R.id.send_message)
    }
    class receiveViewHolder(item: View): RecyclerView.ViewHolder(item){
        val receiveMessage: TextView = item.findViewById(R.id.receive_message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentMessage = messageList[position]

        if (holder.javaClass == sendViewHolder::class.java){
            val viewHolder = holder as sendViewHolder
            holder.sendMessage.text = currentMessage.message

        }else{
            val viewHolder = holder as receiveViewHolder
            holder.receiveMessage.text = currentMessage.message
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}