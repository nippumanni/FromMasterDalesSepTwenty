package com.example.daleshprashar.daleprasseptwenty

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView


public class CustomAdapter(private val context: Context, private val dataList: List<RetroPhoto>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

        inner class CustomViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

            var txtTitle: TextView
            lateinit var   coverImage: ImageView

            init {

                txtTitle = mView.findViewById(R.id.title)
                coverImage = mView.findViewById(R.id.thumbnail)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.content_main, parent, false)
            return CustomViewHolder(view)
        }

        override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
            holder.txtTitle.text = dataList[position].title

            val builder = Picasso.Builder(context)
            builder.downloader(OkHttp3Downloader(context))
            builder.build().load(dataList[position].thumbnailUrl)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.coverImage)

        }

        override fun getItemCount(): Int {
            return dataList.size
        }
    }
