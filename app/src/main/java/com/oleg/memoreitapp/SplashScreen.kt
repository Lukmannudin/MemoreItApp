package com.oleg.memoreitapp

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.oleg.memoreitapp.find_city.FindCityActivity
import kotlinx.android.synthetic.main.splash_screen_layout.*
import org.jetbrains.anko.startActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_layout)

        Glide.with(this)
            .load(R.drawable.memoreit)
            .into(iv_splash_screen_logo)

        Handler().apply {
            postDelayed({
                startActivity<FindCityActivity>()
                finish()
            }, 1000)
        }
    }
}