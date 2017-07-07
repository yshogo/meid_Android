package com.example.shogoyamada.meid.common

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import com.example.shogoyamada.meid.R


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        //戻るボタンの場合
        if (event.keyCode == KeyEvent.KEYCODE_BACK) {
            //trueを返して戻るのを無効化する
            return true
        }
        return super.dispatchKeyEvent(event)
    }


}
