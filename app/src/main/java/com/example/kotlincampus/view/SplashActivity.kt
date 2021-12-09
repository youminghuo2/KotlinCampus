package com.example.kotlincampus.view

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.example.base.util.startActivity
import com.example.kotlincampus.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Math.hypot
import java.util.concurrent.atomic.AtomicBoolean

class SplashActivity : AppCompatActivity() {
    private var keepOnScreen = AtomicBoolean(true)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_splash)

        lifecycleScope.launch {
            delay(2000)
            keepOnScreen.compareAndSet(true, false)
        }
        splashScreen.setKeepVisibleCondition { keepOnScreen.get() }

        splashScreen.setOnExitAnimationListener { provider ->
            showSplashIconExitAnimator(provider.iconView)
            showSplashExitAnimator(provider.iconView) {
                provider.remove()
                startActivity<LoginActivity>()
            }
        }
    }


    // splash screen view 退场动画：透明度 + 揭露
    private fun showSplashExitAnimator(view: View, onExit: () -> Unit) {
        val alphaOut = ObjectAnimator.ofFloat(view, View.ALPHA, 1f, 0.2f)

        val cx = view.width / 2
        val cy = view.height / 2
        // get the start radius for the clipping circle
        val startRadius = hypot(cx.toDouble(), cy.toDouble()).toFloat()
        val revealOut = ViewAnimationUtils.createCircularReveal(
            view, cx, cy, startRadius, 0f
        )

        AnimatorSet().apply {
            duration = 300
            interpolator = DecelerateInterpolator()
            playTogether(alphaOut, revealOut)
            doOnEnd { onExit() }
        }.also { it.start() }
    }

    // splash icon 退场动画：透明度 + 缩放
    private fun showSplashIconExitAnimator(view: View) {
        val alphaOut = ObjectAnimator.ofFloat(view, View.ALPHA, 1f, 0.2f)
        val scaleOut = ObjectAnimator.ofFloat(
            view,
            View.SCALE_X,
            View.SCALE_Y,
            Path().apply {
                moveTo(1f, 1f)
                lineTo(0.2f, 0.2f)
            }
        )

        AnimatorSet().apply {
            duration = 300
            interpolator = DecelerateInterpolator()
            playTogether(alphaOut, scaleOut)
        }.also { it.start() }
    }


}