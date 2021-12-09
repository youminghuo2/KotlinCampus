//package com.example.base.base
//
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.widget.FrameLayout
//import androidx.annotation.LayoutRes
//import androidx.appcompat.widget.Toolbar
//import com.example.base.R
//
//
//abstract class BaseToolBarActivity(@LayoutRes val layoutResId:Int) : BaseActivity(R.layout.activity_base_tool_bar) {
//
//    protected var toolbar: Toolbar? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initToolbarView()
//        LayoutInflater.from(this).inflate(layoutResId, findViewById<FrameLayout>(R.id.container))
//        init()
//    }
//
//    protected abstract fun init()
//
//    private fun initToolbarView() {
//        toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        showBackArrow(isShowBackArrow())
//        toolbar?.setNavigationOnClickListener { finish() }
//    }
//
//    private fun showBackArrow(isShow: Boolean) {
//        supportActionBar?.setHomeButtonEnabled(isShow)
//        supportActionBar?.setDisplayHomeAsUpEnabled(isShow)
//    }
//
//    private fun showToolbar(isShow: Boolean){
//
//    }
//
//    protected open fun isShowToolbar(): Boolean = true
//
//    protected open fun isShowBackArrow(): Boolean = true
//}