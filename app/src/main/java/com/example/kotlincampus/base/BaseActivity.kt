package com.example.kotlincampus.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.network.SHOW_TOAST
import com.example.network.toast
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * @Description:
 * @CreateDate: 2021/12/3 15:44
 */
abstract class BaseActivity : AppCompatActivity(),
    IUiView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeUi()
    }

    private fun observeUi() {
        LiveEventBus.get<String>(SHOW_TOAST).observe(this) {
            toast(it)
        }
    }

    private var progressDialog: ProgressDialog? = null

    override fun showLoading() {
        if (progressDialog == null)
            progressDialog = ProgressDialog(this)
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.takeIf { it.isShowing }?.dismiss()
    }

}