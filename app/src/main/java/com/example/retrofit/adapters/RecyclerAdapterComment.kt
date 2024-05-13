package com.example.retrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.pojo.PostCommentResponse

class RecyclerAdapterComment(
    private val comments : List<PostCommentResponse>
) : RecyclerView.Adapter<RecyclerAdapterComment.MyViewHolder>(){

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val id: TextView = view.findViewById<TextView>(R.id.id_comment)
        val name: TextView = view.findViewById<TextView>(R.id.name)
        val email: TextView = view.findViewById<TextView>(R.id.email)
        val body: TextView = view.findViewById<TextView>(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_comment,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.id.text = comments[position].id.toString()
        holder.name.text = comments[position].name
        holder.email.text = comments[position].email
        holder.body.text = comments[position].body
    }
}