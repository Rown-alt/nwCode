package com.example.nwcode.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nwcode.R
import com.example.nwcode.fragments.SecondPageDirections
import com.example.nwcode.models.Results

class CollectionAdapter : RecyclerView.Adapter<CollectionAdapter.CollectionViewHolder>() {
    private var collection : List<Results> = listOf()
    class CollectionViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val imageView : ImageView = view.findViewById(R.id.category_IV)
        fun bind (photo : Results){
            Glide.with(itemView).load(photo.coverPhoto?.urls?.small).into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.bind(collection[position])

        holder.itemView.setOnClickListener {
            val action = SecondPageDirections.actionSecondPageToThirdPage(collection[position].coverPhoto?.id.toString())
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return collection.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCollection(collection : List<Results>){
        this.collection = collection
        notifyDataSetChanged()
    }
}