package com.example.kotlincampus.customView

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlincampus.R
import com.example.kotlincampus.databinding.IncludeLayoutTitleBinding

/**
 * @Description:
 * @CreateDate: 2021/12/14 9:19
 */
class TitleLayout(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {
    private var binding: IncludeLayoutTitleBinding =
        IncludeLayoutTitleBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.back.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
        
    }
}