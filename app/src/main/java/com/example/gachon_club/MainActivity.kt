package com.example.gachon_club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.Account.SignInActivity
import com.example.gachon_club.Club.ClubActivity
import com.example.gachon_club.Some.Main_Notice
import com.example.gachon_club.Some.Signup
import com.example.gachon_club.Some.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Main_club.setOnClickListener{
            startActivity<ClubActivity>()
        }

        Notice.setOnClickListener{
            startActivity<Main_Notice>(
                "Title" to "공지사항"
            )
        }

        Sign_in.setOnClickListener{
            startActivity<SignInActivity>()
        }
    }
}
