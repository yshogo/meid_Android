package com.example.shogoyamada.meid.activity

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.shogoyamada.meid.R
import com.example.shogoyamada.meid.common.BaseActivity
import com.example.shogoyamada.meid.common.PrefKey
import com.example.shogoyamada.meid.models.UserFormModel
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

/**
 * ログイン処理
 */
class LoginActivity : BaseActivity(), GoogleApiClient.OnConnectionFailedListener {

    private val RC_SIGN_IN = 9001
    private var mAuth: FirebaseAuth? = null
    private val mFirebaseAuth: FirebaseAuth? = null

    private var progressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        progressDialog = ProgressDialog(this)

        //loginボタンに下線を作成
        val loginText = findViewById(R.id.login) as TextView
        loginText.paintFlags =  Paint.UNDERLINE_TEXT_FLAG
        loginText.setOnClickListener { view ->
            // TODO ここにログイン処理を書く
            Toast.makeText(this,"押されました", Toast.LENGTH_SHORT).show()
        }

        if(PrefKey.getPref(this, "email") !== "error"){
            transitionMyPage()
            return
        }

        //新規登録
        normalSubmit()

        //グーグルログイン処理
        googleLogin()

    }

    /**
     * 新規登録
     */
    private fun normalSubmit(){

        val submitButton = findViewById(R.id.submit)
        submitButton.setOnClickListener { view ->
            val userFormModel = getFormData()

            mFirebaseAuth!!.createUserWithEmailAndPassword(userFormModel.email!!, userFormModel.password!!)
                    .addOnCompleteListener(this, { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MyPageActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                        } else {
                            val builder = AlertDialog.Builder(this)
                            builder.setMessage(task.exception.toString())
                                    .setTitle("エラーが発生")
                                    .setPositiveButton(android.R.string.ok, null)
                            val dialog = builder.create()
                            dialog.show()
                        }
                    })
        }
    }

    /**
     * 入力データを取得する
     */
    private fun getFormData() : UserFormModel{

        val name = findViewById(R.id.name_text).toString()
        val email = findViewById(R.id.email_text).toString()
        val password = findViewById(R.id.password_text).toString()

        return UserFormModel(name,email,password)
    }

    /**
     * グーグルログイン処理
     */
    private fun googleLogin(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        val mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()

        val googleButton = findViewById(R.id.googleLoginButton)
        googleButton.setOnClickListener { view ->

            progressDialog!!.show()
            val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntent,RC_SIGN_IN)
        }

        mAuth = FirebaseAuth.getInstance()
    }


    /**
     * 接続失敗
     */
    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        progressDialog!!.dismiss()
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show()
    }

    /**
     * 接続成功後のリスナー
     */
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result.isSuccess) {
                val account:GoogleSignInAccount? = result.signInAccount
                if (account != null) firebaseAuthWithGoogle(account)
            } else {
                println(result.status)
                Toast.makeText(this@LoginActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * グーグルログイン処理
     */
    private fun firebaseAuthWithGoogle(acct : GoogleSignInAccount){
        val credenttial = GoogleAuthProvider.getCredential(acct.idToken, null)

        mAuth!!.signInWithCredential(credenttial)
                .addOnCompleteListener { task ->

                    progressDialog!!.dismiss()

                    if(task.isSuccessful){
                        PrefKey.setPref(this,"email", acct.email)
                        transitionMyPage()
                    }else{
                        Toast.makeText(this,task.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }

    }

    /**
     * マイページに画面遷移する
     */
    private fun transitionMyPage(){
        val intent = Intent(this,MyPageActivity::class.java)
        startActivity(intent)
    }


}
