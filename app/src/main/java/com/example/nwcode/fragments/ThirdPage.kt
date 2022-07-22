package com.example.nwcode.fragments

import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.nwcode.ErrorActivity
import com.example.nwcode.R
import com.example.nwcode.viewModels.ThirdPageViewModel
import com.example.nwcode.viewModels.ThirdPageViewModelFactory
import java.io.IOException


class ThirdPage : Fragment(R.layout.fragment_third_page) {
    private val viewModel : ThirdPageViewModel by activityViewModels { ThirdPageViewModelFactory() }
    private lateinit var imageView : ImageView
    private lateinit var button : Button
    private val arguments : ThirdPageArgs by navArgs()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Request", arguments.id)
        viewModel.getPhotoById(arguments.id)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar : ProgressBar = view.findViewById(R.id.thirdPagePB)
        imageView = view.findViewById(R.id.thirdPageIV)
        button = view.findViewById(R.id.thirdPageBtn)
        viewModel.photoById.observe(viewLifecycleOwner){
            Glide.with(view).load(it.urls?.full.toString()).into(imageView)
        }
        viewModel.exception.observe(viewLifecycleOwner){
            if (it == 1){
                val intent = Intent(activity, ErrorActivity::class.java)
                startActivity(intent)
            }
        }

        button.setOnClickListener {
            val bmap : Bitmap = imageView.drawToBitmap()
            val m = WallpaperManager.getInstance(context)
            try {
                m.setBitmap(bmap)
                Toast.makeText(context, "Wallpaper Set Successfully", Toast.LENGTH_SHORT).show()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}