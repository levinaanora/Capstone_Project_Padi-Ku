package org.tensorflow.lite.examples.classification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneprojectpadiku.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
    }
}