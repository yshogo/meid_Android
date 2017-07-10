package com.example.shogoyamada.meid.enums;

/**
 * Created by shogo.yamada on 2017/07/10.
 */

public enum PostArticleFlagmentKey {

    POST_PAGE(0,"投稿ページ")
    ,PREVIRE_PAGE(1,"プレビューページ")
    ;

    private int position;

    private String description;

    PostArticleFlagmentKey(int position, String description){
        this.position = position;
        this.description = description;
    }

    public int getPosition(){
        return this.position;
    }
}
