package com.oleg.memoreitapp

import com.oleg.memoreitapp.model.PhotoSession

object PhotoSessionData {
    private val semipro = listOf(
            PhotoSession(
                "1",
                "Yogyakarta Semi-Pro Photo Session",
                "Bandung",
                100000,
                "asdasdwasd",
                3,
                R.drawable.bandung_semi_pro_photo_session.toString(),
                Utils.CATEGORY_SEMIPRO,
                "paypal"
            ),
        PhotoSession(
            "1",
            "Yogyakarta Semi-Pro Photo Session",
            "Bandung",
            100000,
            "asdasdwasd",
            3,
            R.drawable.bandung_semi_pro_photo_session.toString(),
            Utils.CATEGORY_SEMIPRO,
            "paypal"
        )
//            PhotoSession(R.drawable.yogyakarta_semi_pro_photo_session.toString(),"Yogyakarta Semi-Pro Photo Session",3,1000000)
    )

//    private val professional = listOf(
//            PhotoSession(R.drawable.bandung_pro_photo_session.toString(),"Bandung Pro Photo Session",3,2000000),
//            PhotoSession(R.drawable.yogyakarta_pro_photo_session.toString(),"Yogyakarta Pro Photo Session",3,2000000)
//    )

    fun getPhotoSessionSemiPro():List<PhotoSession> {
        return semipro
    }

    fun getPhotoSessionProfessional():List<PhotoSession>{
        return semipro
    }
}