package com.oleg.memoreitapp.add_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.startActivity

class AddInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        btn_addinfo_next.setOnClickListener {
            startActivity<PaymentActivity>()
        }
    }
}
