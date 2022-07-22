package com.example.nwcode.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nwcode.R
import com.example.nwcode.fragments.FirstPageDirections

import com.example.nwcode.models.Results

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoriesViewHolder>() {
    private var listPhotos : List<Results> = listOf()
    class CategoriesViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val imageView : ImageView = view.findViewById(R.id.category_IV)
        private val categoryName : TextView = view.findViewById(R.id.category_name)
        fun bind(photo : Results){
            Glide.with(itemView).load(photo.coverPhoto?.urls?.small).into(imageView)
            categoryName.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(listPhotos[position])

        holder.itemView.setOnClickListener {
            val action = FirstPageDirections.actionFirstPageToSecondPage(listPhotos[position].title.toString())
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listPhotos.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCategories(listPhoto : List<Results>){
        this.listPhotos = listPhoto
        notifyDataSetChanged()
    }
}