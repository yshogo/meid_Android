package com.example.shogoyamada.meid.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by shogo.yamada on 2017/07/07.
 */

public class PrefKey {

    /**
     * データを登録する
     * @param activity アクティビティ
     * @param key キー
     * @param value バリュー
     */
    public static void setPref(BaseActivity activity , String key, String value){
        SharedPreferences data = activity.getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();
        editor.putString(key,value);
        editor.apply();
    }

    /**
     * データを取得する
     * @param activity アクティビティ
     * @param key キー
     * @return キーに対応するバリュー
     */
    public static String getPref(BaseActivity activity, String key){
        SharedPreferences data = activity.getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        return data.getString(key, "error");
    }
}
