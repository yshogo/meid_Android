package com.example.shogoyamada.meid.activity

import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import com.example.shogoyamada.meid.R
import com.example.shogoyamada.meid.common.BaseActivity



class MyPageActivity : BaseActivity() {


    private var toggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_page)

        //ツールバーの作成
        createToolbar()
    }

    /**
     * ツールバーを作成
     */
    private fun createToolbar(){
        //ツールバーを初期化
        val toolbar = findViewById(R.id.tool_bar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)

        //トグルボタンを作成
        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        toggle!!.drawerArrowDrawable //ドロワーの使うか使わないかのオンオフ
        drawerLayout.addDrawerListener(toggle!!)
    }

    /**
     * レイアウト生成後にtoolbarを生成する
     */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        toggle!!.syncState()
    }
}
