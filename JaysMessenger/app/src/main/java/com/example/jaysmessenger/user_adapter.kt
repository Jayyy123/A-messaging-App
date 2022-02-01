package com.example.jaysmessenger

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class user_adapter(val context:Context, val userList:ArrayList<User>): RecyclerView.Adapter<user_adapter.userviewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userviewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false)
        return userviewHolder(view)
    }

    override fun onBindViewHolder(holder: userviewHolder, position: Int) {
        val currentuser = userList[position]
        holder.username.text = currentuser.name

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class userviewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val username = itemView.findViewById<TextView>(R.id.username)
    }

}