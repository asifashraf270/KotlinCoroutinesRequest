package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincoroutines.databinding.ActivitySingleNetworkCallBinding
import com.example.kotlincoroutines.network.ApiHelperImp
import com.example.kotlincoroutines.network.RetrofitBuilder
import com.example.kotlincoroutines.viewmodel.SingleNetworkCallViewModel

private const val TAG = "SingleNetworkCallActivi"
class SingleNetworkCallActivity : AppCompatActivity() {

    lateinit var binding:ActivitySingleNetworkCallBinding
    lateinit  var viewModel: SingleNetworkCallViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySingleNetworkCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this,MyViewModelFactory(ApiHelperImp(RetrofitBuilder.apiService)))[SingleNetworkCallViewModel::class.java]
        initObserver()
    }
    private fun initObserver(){
        viewModel.user.observe(this,{
            Log.e(TAG,it.toString())
        })
    }
}