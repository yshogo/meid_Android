package com.example.shogoyamada.meid.common

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.meid.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun next(clazz : Class<out AppCompatActivity >){
        var intent = Intent(this,clazz);
        startActivity(intent)
    }

}
