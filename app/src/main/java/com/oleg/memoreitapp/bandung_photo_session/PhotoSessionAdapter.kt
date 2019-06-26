package com.oleg.memoreitapp.bandung_photo_session

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oleg.memoreitapp.BuildConfig
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.model.PhotoSession
import kotlinx.android.synthetic.main.item_photo_session.view.*
import java.text.NumberFormat
import java.util.*

class PhotoSessionAdapter(
        private val context: Context,
        private val order: Order,
        private val dataset: List<PhotoSession>,
        private val listener: PhotoSessionFragment.PhotoSessionItemListener
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
        holder.bindItem(context, dataset[position],order,listener)
    }

    class PhotoSessionHolder(view: View):RecyclerView.ViewHolder(view) {
        private val photoThumbnail = view.iv_thumbnail_photo_session_item
        private val title = view.tv_photo_session_title_item
        private val longPhotographing = view.tv_photo_session_long_item
        private val price = view.tv_photo_session_price_item
        private val btn_book = view.btn_photo_session_book_item

        fun bindItem(context: Context, photoSession: PhotoSession,order: Order,
                     listener: PhotoSessionFragment.PhotoSessionItemListener){

            val formatRupiah = NumberFormat.getCurrencyInstance(Locale("in","ID"))

//            photoThumbnail.setImageResource(photoSession.imageUrl!!.toInt())
            Glide.with(context)
                .load(BuildConfig.BASE_URL +"uploads/img/"+
                        photoSession.imageUrl)
                .into(photoThumbnail)


            title.text = photoSession.title
            longPhotographing.text = photoSession.duration.toString() + " hr"
            price.text = formatRupiah.format(photoSession.price)
            btn_book.setOnClickListener {
                order.service = title.text as String
                order.duration =  longPhotographing.text.toString()
                order.price = price.text.toString()
                order.id_service = photoSession.idService.toString()
                listener.onPhotoSessionClick(photoSession,order)
            }
        }
    }
}