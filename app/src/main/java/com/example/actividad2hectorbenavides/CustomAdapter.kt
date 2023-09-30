package com.example.actividad2hectorbenavides

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private var mList: MutableList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var lista: MutableList<ItemsViewModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]


        holder.imageView.setImageResource(ItemsViewModel.image)


        holder.textView.text = ItemsViewModel.textName
        holder.textViewDesc.text = ItemsViewModel.textDescription


    }


    override fun getItemCount(): Int {
        return mList.size
    }

    fun clearData() {
        mList.clear()
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageviewFoto)
        val textView: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewDesc: TextView = itemView.findViewById(R.id.textViewDescripcion)
    }
}