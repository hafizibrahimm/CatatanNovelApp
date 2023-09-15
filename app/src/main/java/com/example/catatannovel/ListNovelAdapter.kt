package com.example.catatannovel

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListNovelAdapter (private val listNovel: ArrayList<Novel>)  : RecyclerView.Adapter<ListNovelAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvAuthor: TextView = itemView.findViewById(R.id.tv_item_author)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_novel, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listNovel.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, author, description, photo) = listNovel[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvAuthor.text = author
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailNovel::class.java)
            intent.putExtra("NOVEL_DATA", listNovel[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}