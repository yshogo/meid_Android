package com.example.shogoyamada.meid.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.shogoyamada.meid.R;
import com.example.shogoyamada.meid.adapeters.PostArticleFlagmentAdapter;

public class PostArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article);

        initFlagment();

    }

    /**
     * フラグメントの初期設定
     */
    private void initFlagment(){
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        PostArticleFlagmentAdapter adapter = new PostArticleFlagmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
