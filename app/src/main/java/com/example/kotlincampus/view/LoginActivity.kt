package com.example.kotlincampus.view

import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextUtils
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import com.example.base.base.BaseActivity

import com.example.base.util.launchWithLoadingAndCollect
import com.example.base.util.startActivity
import com.example.kotlincampus.R
import com.example.kotlincampus.databinding.ActivityLoginBinding

import com.example.kotlincampus.viewmodel.LoginViewModel

import com.example.network.toast

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val model: LoginViewModel by viewModels()

    companion object {
        private const val tag = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         *用户协议
         */
        val privacyText = getString(R.string.privacy_check)
        val privacy = getString(R.string.privacy)
        val spanSpannableString = SpannableString(privacyText)
        spanSpannableString.setSpan(
            getColor(R.color.purple_500),
            privacy.indexOf(privacy),
            privacy.indexOf(privacy) + privacy.length,
            SpannableString.SPAN_INCLUSIVE_INCLUSIVE
        )
        spanSpannableString.setSpan(
            object : ClickableSpan() {
                override fun onClick(widget: View) {
                    startActivity<PrivacyActivity>()
                }

            },
            spanSpannableString.indexOf(privacy),
            spanSpannableString.indexOf(privacy) + privacy.length,
            SpannableString.SPAN_INCLUSIVE_INCLUSIVE
        )

        binding.privacyTv.text = spanSpannableString
        binding.privacyTv.movementMethod = LinkMovementMethod.getInstance()
        binding.privacyTv.highlightColor = getColor(android.R.color.transparent)

        binding.loginBtn.setOnClickListener {
            if (!binding.privacyCheckbox.isChecked) {
                com.example.base.util.toast(getString(R.string.privacy_check))
            } else {
                val accText = binding.accTextField.editText?.text.toString()
                val psdText = binding.psdTextField.editText?.text.toString()
                when {
                    TextUtils.isEmpty(accText) -> {
                        binding.accTextField.error = getString(R.string.acc_null)
                        com.example.base.util.toast(getString(R.string.acc_null))
                    }
                    TextUtils.isEmpty(psdText) -> {
                        binding.psdTextField.error = getString(R.string.psd_null)
                        com.example.base.util.toast(getString(R.string.psd_null))
                    }
                    else -> {
                        login()
                    }
                }
            }
        }


        binding.accTextField.editText?.doOnTextChanged { text, start, before, count ->
            val inputTextWatcher = binding.accTextField.editText?.text.toString()
            if (!TextUtils.isEmpty(inputTextWatcher)) {
                binding.accTextField.error = null
            }
        }

        binding.psdTextField.editText?.doOnTextChanged { text, start, before, count ->
            val inputTextWatcher = binding.psdTextField.editText?.text.toString()
            if (!TextUtils.isEmpty(inputTextWatcher)) {
                binding.psdTextField.error = null
            }
        }

    }


    private fun login() {
        launchWithLoadingAndCollect({
            model.login(
                "18014190570", "de88e3e4ab202d87754078cbb2df6063", "ANDROID",
                "2.7.10"
            )
        }) {
            onSuccess = {
                startActivity<MainHomeActivity>()
            }
            onFailed = { errorCode, errorMsg ->
                toast("errorCode: $errorCode   errorMsg: $errorMsg")
            }

        }
    }


}


/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}