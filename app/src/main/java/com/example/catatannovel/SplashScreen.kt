package com.example.catatannovel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private val SplashScreenDelay = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen) // Ganti dengan nama layout splash screen Anda

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(
                this@SplashScreen,
                MainActivity::class.java
            ) // Ganti dengan nama aktivitas utama Anda
            startActivity(intent)
            finish() // Tutup aktivitas splash screen agar tidak bisa kembali ke sana
        }, SplashScreenDelay)
    }
}