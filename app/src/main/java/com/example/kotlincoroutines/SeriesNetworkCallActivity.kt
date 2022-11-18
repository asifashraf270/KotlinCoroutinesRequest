package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.databinding.ActivitySeriesNetworkCallBinding
import com.example.kotlincoroutines.network.ApiHelperImp
import com.example.kotlincoroutines.network.RetrofitBuilder
import com.example.kotlincoroutines.viewmodel.SeriesViewModel

private const val TAG = "SeriesNetworkCallActivi"
class SeriesNetworkCallActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeriesNetworkCallBinding
    lateinit var viewmodel: SeriesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeriesNetworkCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel = ViewModelProvider(
            this,
            MyViewModelFactory(ApiHelperImp(RetrofitBuilder.apiService))
        )[SeriesViewModel::class.java]
        initObserver()
    }

    private fun initObserver() {
        viewmodel.user.observe(this, {
        Log.e(TAG,it.toString())
        })
    }
}