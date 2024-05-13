package com.example.retrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.pojo.PostResponse

class RecyclerAdapter(private val posts : List<PostResponse>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById<TextView>(R.id.title)
        val description: TextView = view.findViewById<TextView>(R.id.description)
        val id: TextView = view.findViewById<TextView>(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val post = posts[position]
        holder.id.text = post.id.toString()
        holder.title.text = post.title
        holder.description.text = post.body
    }


}