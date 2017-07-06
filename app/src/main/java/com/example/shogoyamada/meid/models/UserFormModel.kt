package com.example.shogoyamada.meid.models

/**
 * Created by shogo.yamada on 2017/07/06.
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
