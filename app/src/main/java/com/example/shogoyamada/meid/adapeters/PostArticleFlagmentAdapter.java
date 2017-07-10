package com.example.shogoyamada.meid.adapeters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.shogoyamada.meid.fragments.PostArticleFragment;

/**
 * 投稿画面のフラグメントアダプター
 */
public class PostArticleFlagmentAdapter extends FragmentPagerAdapter {

    public PostArticleFlagmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PostArticleFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){

        if(position == 1){
            return "Preview";
        }else{
            return "Post";
        }
    }
}
