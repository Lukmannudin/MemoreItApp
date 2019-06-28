package com.oleg.memoreitapp.bandung_photo_session

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oleg.memoreitapp.APIRequest.PhotoSessionService
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.Utils.FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL
import com.oleg.memoreitapp.Utils.FIND_PHOTOGRAPHER_PAGE_SEMIPRO
import com.oleg.memoreitapp.Utils.SIMPLE_INTENT_NAME
import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.model.PhotoSession
import com.oleg.memoreitapp.pick_date.PickDateActivity
import com.oleg.memoreitapp.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_photo_session.*
import kotlinx.android.synthetic.main.fragment_photo_session.view.*

class PhotoSessionFragment : Fragment() {

    private lateinit var order: Order
    private lateinit var adapter: PhotoSessionAdapter

    private val dataset: MutableList<PhotoSession> = mutableListOf()
    private var pageName: String? = null

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            order = it.getParcelable(Utils.ORDER)
            pageName = it.getString(Utils.PAGE)
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
        adapter = context?.let { PhotoSessionAdapter(it, order, dataset, itemListener) }!!
        rv_photo_session.adapter = adapter
        setDataForPage()
    }

    private fun setDataForPage() {

        when (pageName) {
            FIND_PHOTOGRAPHER_PAGE_SEMIPRO -> {
                loadPhotoSession(Utils.CATEGORY_SEMIPRO)
            }
            FIND_PHOTOGRAPHER_PAGE_PROFESSIONAL -> {
                loadPhotoSession(Utils.CATEGORY_PROFESSIONAL)
            }
        }
    }

    companion object {
        fun newInstance(order: Order, page: String) =
            PhotoSessionFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(Utils.ORDER, order)
                    putString(Utils.PAGE, page)
                }
            }
    }

    private val itemListener: PhotoSessionItemListener = object : PhotoSessionItemListener {
        override fun onPhotoSessionClick(clickedPhotoSession: PhotoSession, order: Order) {
            val intent = Intent(context, PickDateActivity::class.java)
            order.city = clickedPhotoSession.city.toString()
            intent.putExtra(SIMPLE_INTENT_NAME, order)
            startActivity(intent)
        }
    }

    private fun loadPhotoSession(category: String) {
        val service: PhotoSessionService = ApiService.photoSessionService
        disposable = service.getPhotoSessionServicePro(category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    dataset.clear()
                    dataset.addAll(result.data)
                    adapter.notifyDataSetChanged()
                    photo_session_proggress_bar.visibility = View.GONE
                },
                { error ->
                    Log.e("Error", error.cause.toString())
                }
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }


    interface PhotoSessionItemListener {
        fun onPhotoSessionClick(clickedPhotoSession: PhotoSession, order: Order)
    }
}
