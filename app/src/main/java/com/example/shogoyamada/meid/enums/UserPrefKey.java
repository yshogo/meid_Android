package com.example.shogoyamada.meid.enums;

/**
 * Created by shogo.yamada on 2017/07/10.
 */

public enum UserPrefKey {

    USER_EMAIL("email");

    private String email;

    UserPrefKey(String email){
        this.email = email;
    }

    public String getEmailPref(){
        return this.email;
    }
}
