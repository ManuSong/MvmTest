package com.risingcamp.manu.mvmtest.config

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class  BaseActivity<B : ViewBinding>(private  val inflate : (LayoutInflater) -> B) : AppCompatActivity() {
    protected lateinit var binding : B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showCustomToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}