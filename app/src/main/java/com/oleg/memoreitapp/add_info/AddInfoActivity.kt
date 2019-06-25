package com.oleg.memoreitapp.add_info

import android.os.Bundle
import android.view.MenuItem
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
            var statusInputText = true

            if (edt_add_info_name.editText?.text?.isEmpty()!!){
                edt_add_info_name.error = "Name is required"
                statusInputText = false
            }

            if (edt_add_info_email.editText?.text?.isEmpty()!!){
                edt_add_info_email.error = "Email is required"
                statusInputText = false
            }

            if (edt_add_info_phone_number.editText?.text?.isEmpty()!!){
                edt_add_info_phone_number.error = "Phone Number is required"
                statusInputText = false
            }

            if (statusInputText){
                startActivity<PaymentActivity>()
            }
        }

        supportActionBar?.title = "Add your Info"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        edt_add_info_email.error
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home){
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
