package com.example.gachon_club.Account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.gachon_club.Account.Model.User
import com.example.gachon_club.Network.ServiceControl
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    var list_of_items = arrayOf("정남규", "박건호", "동아리 회장", "동아리 부회장", "쫄따구")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        edit_position.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list_of_items)

        btn_signup.setOnClickListener{

            val ID = edit_username.text.toString()
            val PW = edit_password.text.toString()
            val NAME = edit_name.text.toString()
            val MAJOR = edit_major.text.toString()
            val CLUB = edit_club.text.toString()
            val POSITION = edit_position.selectedItem.toString()

            if((!ID.isNullOrBlank()) && (!PW.isNullOrBlank()) && (!NAME.isNullOrBlank()) && (!MAJOR.isNullOrBlank()) && (!CLUB.isNullOrBlank()) && (!POSITION.isNullOrBlank())) {
                val user = User(
                    edit_username.text.toString(),
                    edit_password.text.toString(),
                    edit_name.text.toString(),
                    edit_major.text.toString(),
                    edit_club.text.toString(),
                    edit_position.selectedItem.toString())
                addData(user)
            } else {
                Toast.makeText(this, "빠짐없이 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun addData(user:User) {
        val retrofitService = ServiceControl.getInstance()
        retrofitService?.addUser(user)?.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    Toast.makeText(applicationContext, "회원가입 성공", Toast.LENGTH_LONG).show()
                    finish()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "ID 중복", Toast.LENGTH_LONG).show()
            }
        })
    }
}
