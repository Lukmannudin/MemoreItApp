package com.oleg.memoreitapp.add_info

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.oleg.memoreitapp.R
import com.oleg.memoreitapp.Utils
import com.oleg.memoreitapp.model.Order
import com.oleg.memoreitapp.payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_add.*
import org.jetbrains.anko.startActivity
import java.util.regex.Pattern.compile

class AddInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val intent = intent.getParcelableExtra<Order>(Utils.SIMPLE_INTENT_NAME)

        btn_addinfo_next.setOnClickListener {
            var statusInputText = true

            if (edt_add_info_name.editText?.text?.isEmpty()!!) {
                edt_add_info_name.error = "Name is required"
                statusInputText = false
            }

            if (edt_add_info_email.editText?.text?.isEmpty()!!) {
                edt_add_info_email.error = "Email is required"
                statusInputText = false
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(edt_add_info_email.editText?.text?.toString()).matches()) {
                edt_add_info_email.error = "This field has to be a valid email address"
                statusInputText = false
            }

            if (edt_add_info_phone_number.editText?.text?.isEmpty()!!) {
                edt_add_info_phone_number.error = "Phone Number is required"
                statusInputText = false
            }



            if (statusInputText) {
                intent.name_customer = edt_add_info_name.editText?.text.toString()
                intent.email_customer = edt_add_info_email.editText?.text.toString()
                intent.phone_number = edt_add_info_phone_number.editText?.text.toString()
                intent.message = edt_add_info_message.editText?.text.toString()
                startActivity<PaymentActivity>(
                    Utils.SIMPLE_INTENT_NAME to intent
                )
            }
        }

        supportActionBar?.title = "Add your Info"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        edt_add_info_email.error
    }

    private val emailRegex = compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun String.isEmail(): Boolean {
        return emailRegex.matcher(this).matches()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
