package com.example.shogoyamada.meid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shogoyamada.meid.R;

/**
 * 投稿画面のpostのフラグメント
 */

public class PostArticleFragment extends Fragment {

    public PostArticleFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view;

        Bundle args = getArguments();
        int position = args.getInt("position");

        if(position == 1){
            view = inflater.inflate(R.layout.view_flagment_preview,container,false);
        }else{
            view = inflater.inflate(R.layout.view_flagment_post, container, false);
        }

        return view;
    }

    public static PostArticleFragment newInstance(int position) {

        Bundle args = new Bundle();

        args.putInt("position", position);

        PostArticleFragment fragment = new PostArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
