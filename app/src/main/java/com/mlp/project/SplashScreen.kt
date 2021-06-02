package com.mlp.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(4100L)
            endSplash()
        }
    }

    private fun endSplash(){
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
    }
}
