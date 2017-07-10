package com.example.shogoyamada.meid.activity

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.example.shogoyamada.meid.R
import com.example.shogoyamada.meid.adapeters.PostArticleFlagmentAdapter

class PostArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_article)

        initFlagment()
    }

    /**
     * フラグメントの初期設定
     */
    private fun initFlagment() {
        val tabLayout = findViewById(R.id.tab_layout) as TabLayout
        val viewPager = findViewById(R.id.view_pager) as ViewPager

        val adapter = PostArticleFlagmentAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

}
