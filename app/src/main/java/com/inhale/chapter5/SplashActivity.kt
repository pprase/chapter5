package com.inhale.chapter5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.inhale.chapter5.databinding.ActivitySplashBinding
import kotlin.concurrent.timer

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val timer = object : CountDownTimer(3000,1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
            startActivity(Intent(this@SplashActivity,LandingPageActivity::class.java))
            }

        }
        timer.start()
    }
}