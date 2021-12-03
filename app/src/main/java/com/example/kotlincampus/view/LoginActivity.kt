package com.example.kotlincampus.view

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import com.example.kotlincampus.base.BaseActivity
import com.example.kotlincampus.base.launchWithLoadingAndCollect
import com.example.kotlincampus.databinding.ActivityLoginBinding
import com.example.kotlincampus.entity.LoginEntity
import com.example.kotlincampus.viewmodel.LoginViewModel
import com.example.network.toast

class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewmodel: LoginViewModel by viewModels()

    companion object {
        private const val tag = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            login()
        }

    }


    private fun login() {
        launchWithLoadingAndCollect({
            viewmodel.login(
                binding.username.text.toString(),
                "e10adc3949ba59abbe56e057f20f883e",
                "ANDROID",
                "2.7.5"
            )
        }) {
            onSuccess = {
                it?.let {
                    Log.d(tag, "返回的参数是" + it.userPrincipal.name)
                }
                Log.d(tag, "返回的参数是 " + it.toString())
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