package com.example.shogoyamada.meid.models

/**
 * ユーザー情報を管理する
 */
class UserFormModel {

    init { }

    var userName: String? = null

    var email: String? = null

    var password: String? = null

    constructor(userName :String, email :String, password: String){
        this.userName = userName
        this.email = email
        this.password = password
    }
}
