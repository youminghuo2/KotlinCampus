//package com.example.base.base
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.appcompat.widget.Toolbar
//import com.example.base.databinding.ActivityBaseToolBarBinding
//
//abstract class BaseToolBarActivity : BaseActivity() {
//
//    protected var toolbar: Toolbar? = null
//    private lateinit var binding: ActivityBaseToolBarBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        initToolbarView()
//        binding = ActivityBaseToolBarBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        init()
//    }
//
//    protected abstract fun init()
//
//    private fun initToolbarView() {
//        setSupportActionBar(binding.toolbar)
//        showBackArrow(isShowBackArrow())
//        toolbar?.setNavigationOnClickListener { finish() }
//    }
//
//    private fun showBackArrow(isShow: Boolean) {
//        supportActionBar?.setHomeButtonEnabled(isShow)
//        supportActionBar?.setDisplayHomeAsUpEnabled(isShow)
//    }
//
//    protected open fun isShowBackArrow(): Boolean = true
//}