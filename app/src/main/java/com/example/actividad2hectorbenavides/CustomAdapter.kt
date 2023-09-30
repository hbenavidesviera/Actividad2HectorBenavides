package com.example.actividad2hectorbenavides

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(private var mList: MutableList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var lista: MutableList<ItemsViewModel> = ArrayList()

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.textName
        holder.textViewDesc.text = ItemsViewModel.textDescription


    }

    // return the number of the items in the list
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