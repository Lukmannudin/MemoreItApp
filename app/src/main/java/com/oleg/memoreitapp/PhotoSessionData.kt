package com.oleg.memoreitapp

import com.oleg.memoreitapp.model.PhotoSession

object PhotoSessionData {
    private val semipro = listOf(
            PhotoSession(R.drawable.bandung_semi_pro_photo_session.toString(),"Bandung Semi-Pro Photo Session",3,1000000),
            PhotoSession(R.drawable.yogyakarta_semi_pro_photo_session.toString(),"Yogyakarta Semi-Pro Photo Session",3,1000000)
    )

    private val professional = listOf(
            PhotoSession(R.drawable.bandung_pro_photo_session.toString(),"Bandung Pro Photo Session",3,2000000),
            PhotoSession(R.drawable.yogyakarta_pro_photo_session.toString(),"Yogyakarta Pro Photo Session",3,2000000)
    )

    fun getPhotoSessionSemiPro():List<PhotoSession> {
        return semipro
    }

    fun getPhotoSessionProfessional():List<PhotoSession>{
        return professional
    }
}