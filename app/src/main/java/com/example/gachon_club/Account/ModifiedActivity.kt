package com.example.gachon_club.Account

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.gachon_club.Account.Model.User
import com.example.gachon_club.Network.ServiceControl
import com.example.gachon_club.R
import kotlinx.android.synthetic.main.activity_modified.*
import kotlinx.android.synthetic.main.activity_sign_up.edit_club
import kotlinx.android.synthetic.main.activity_sign_up.edit_major
import kotlinx.android.synthetic.main.activity_sign_up.edit_name
import kotlinx.android.synthetic.main.activity_sign_up.edit_password
import kotlinx.android.synthetic.main.activity_sign_up.edit_position
import kotlinx.android.synthetic.main.activity_sign_up.edit_username
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ModifiedActivity : AppCompatActivity() {

    var list_of_items = arrayOf("정남규", "박건호", "동아리 회장", "동아리 부회장", "쫄따구")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modified)

        edit_position.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list_of_items)

        val user:User = intent.getParcelableExtra<User>("userInfo")
        edit_username.setText(user.userId)
        edit_password.setText(user.userPw)
        edit_name.setText(user.name)
        edit_major.setText(user.major)
        edit_club.setText(user.club)
        edit_position.setSelection(getIndex(edit_position, user.position))

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        btn_modify.setOnClickListener{

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
                modifyData(user)
            } else {
                Toast.makeText(this, "빠짐없이 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun getIndex(spinner: Spinner, item:String):Int{
        for(i in 0..spinner.count){
            if(spinner.getItemAtPosition(i).toString().equals(item)){
                return i;
            }
        }
        return 0;
    }
    private fun modifyData(user: User) {
        val retrofitService = ServiceControl.getInstance()
        retrofitService?.modifyUser(user)?.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.let {
                        Toast.makeText(applicationContext, "회원정보 수정", Toast.LENGTH_LONG).show()
                        val intent = Intent()
                        intent.putExtra("userInfo", it)
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(applicationContext, "ID가 틀렸어요", Toast.LENGTH_LONG).show()
            }
        })
    }
}
