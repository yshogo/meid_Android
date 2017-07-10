package com.example.shogoyamada.meid.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.shogoyamada.meid.R;

public class PostArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 2"));
    }
}
