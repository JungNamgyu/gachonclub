package com.example.gachon_club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.ui.login.LoginActivity
import com.example.gachon_club.ui.login.SignUp
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Main_club.setOnClickListener{
            Title.text = "중앙 동아리"
            startActivity<Main_Club>()
        }
        sub_club.setOnClickListener{
            Title.text = "과 동아리"
            startActivity<Main_Club>()
        }
        Sign_in.setOnClickListener{ startActivity<LoginActivity>() }
        Sign_Up.setOnClickListener{ startActivity<SignUp>() }
    }
}
