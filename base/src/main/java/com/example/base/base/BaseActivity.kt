package com.example.base.base

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.network.SHOW_TOAST
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * @Description:
 * @CreateDate: 2021/12/3 15:44
 */
abstract class BaseActivity : AppCompatActivity(), IUiView {

    companion object {
        private const val TAG = "当前的activity:"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeUi()
        Log.d(TAG, javaClass.simpleName)
    }

    private fun observeUi() {
        LiveEventBus.get<String>(SHOW_TOAST).observe(this) {
            com.example.base.util.toast(it)
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