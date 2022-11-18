package com.example.kotlincoroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import com.example.kotlincoroutines.viewmodel.SeriesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.singleNetworkCall.setOnClickListener{
            startActivity(Intent(this,SingleNetworkCallActivity::class.java))
        }
        binding.seriesNetworkCall.setOnClickListener{
            startActivity(Intent(this,SeriesNetworkCallActivity::class.java))
        }
    }
}