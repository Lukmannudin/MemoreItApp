package com.oleg.memoreitapp.bandung_photo_session

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.model.PhotoSession
import kotlinx.android.synthetic.main.item_photo_session.view.*

class PhotoSessionAdapter (
    private val context: Context,
    private val dataset: List<PhotoSession>,
    private val listener: PhotoSessionOneFragment.PhotoSessionItemListener
) :
        RecyclerView.Adapter<PhotoSessionAdapter.PhotoSessionHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoSessionHolder {
        return PhotoSessionHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo_session,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: PhotoSessionHolder, position: Int) {
        holder.bindItem(context, dataset[position],listener)
    }

    class PhotoSessionHolder(view: View):RecyclerView.ViewHolder(view) {
        private val photoThumbnail = view.iv_thumbnail_photo_session_item
        private val title = view.tv_photo_session_title_item
        private val longPhotographing = view.tv_photo_session_long_item
        private val price = view.tv_photo_session_price_item

        fun bindItem(context: Context, photoSession: PhotoSession,
                     listener: PhotoSessionOneFragment.PhotoSessionItemListener){

            title.text = photoSession.title
            longPhotographing.text = photoSession.long.toString()
            price.text = photoSession.price.toString()
        }
    }
}