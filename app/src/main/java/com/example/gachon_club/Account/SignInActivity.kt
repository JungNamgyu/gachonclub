package com.example.gachon_club.Account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gachon_club.Account.Model.User
import com.example.gachon_club.R
import com.example.gachon_club.Network.ServiceControl
import kotlinx.android.synthetic.main.activity_sign_in.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btn_login.setOnClickListener{

            val ID = edit_username.text.toString()
            val PW = edit_password.text.toString()

            if((!ID.isNullOrBlank()) && (!PW.isNullOrBlank())) {
                loadData(ID, PW)
            } else {
                Toast.makeText(this, "아이디/비밀번호를 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadData(ID: String, PW: String) {
        val retrofitService = ServiceControl.getInstance()
        retrofitService?.getUser(ID)?.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        if(it.userPw.toString() == PW){
                            Toast.makeText(applicationContext, "로그인 성공", Toast.LENGTH_LONG).show()
                            Toast.makeText(applicationContext, "니 이름 : " + it.name.toString(), Toast.LENGTH_LONG).show()
                        }
                        else{
                            Toast.makeText(applicationContext, "로그인 실패", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "연결 실패", Toast.LENGTH_LONG).show()
            }
        })
    }
}
