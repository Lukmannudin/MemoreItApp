package com.oleg.memoreitapp.bandung_photo_session

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oleg.memoreitapp.PhotoSessionData
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.Utils.FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL
import com.oleg.memoreitapp.Utils.FIND_PHOTOGRAPHER_PAGE_SEMIPRO
import com.oleg.memoreitapp.Utils.SIMPLE_INTENT_NAME
import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.model.PhotoSession
import com.oleg.memoreitapp.pick_date.PickDateActivity
import kotlinx.android.synthetic.main.fragment_photo_session.*
import kotlinx.android.synthetic.main.fragment_photo_session.view.*



class PhotoSessionFragment : Fragment() {

    private lateinit var order :Order
    private lateinit var adapter: PhotoSessionAdapter

    private val dataset: MutableList<PhotoSession> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            order = it.getParcelable(Utils.ORDER)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_photo_session, container, false)
        view.rv_photo_session.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setDataForPage()
        adapter = context?.let { PhotoSessionAdapter(it, order, dataset, itemListener) }!!
        rv_photo_session.adapter = adapter
    }

    private fun setDataForPage(){
        when(order.service) {
            FIND_PHOTOGRAPHER_PAGE_SEMIPRO -> {
                dataset.addAll(PhotoSessionData.getPhotoSessionSemiPro())
            }
            FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL -> {
                dataset.addAll(PhotoSessionData.getPhotoSessionProfessional())
            }
        }
    }

    companion object {
        fun newInstance(order: Order) =
                PhotoSessionFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable(Utils.ORDER, order)
                    }
                }
    }

    private val itemListener: PhotoSessionItemListener = object : PhotoSessionItemListener {
        override fun onPhotoSessionClick(clickedPhotoSession: PhotoSession, order: Order) {
            val intent = Intent(context,PickDateActivity::class.java)
            intent.putExtra(SIMPLE_INTENT_NAME,order)
            startActivity(intent)
        }
    }

    interface PhotoSessionItemListener {
        fun onPhotoSessionClick(clickedPhotoSession: PhotoSession, order: Order)
    }
}
