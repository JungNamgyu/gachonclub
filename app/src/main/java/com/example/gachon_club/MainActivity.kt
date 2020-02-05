package com.example.gachon_club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Main_club.setOnClickListener{
            startActivity<Main_Club>(
                "Title" to "중앙동아리"
            )
        }
        sub_club.setOnClickListener{
            startActivity<Main_Club>(
                "Title" to "과동아리"
            )
        }
        Sign_in.setOnClickListener{ startActivity<LoginActivity>() }

        Sign_Up.setOnClickListener{ startActivity<New_Account>() }

    }
}
