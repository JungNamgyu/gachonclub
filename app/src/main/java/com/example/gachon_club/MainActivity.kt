package com.example.gachon_club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gachon_club.Club.ClubActivity
import com.example.gachon_club.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Main_club.setOnClickListener{
            startActivity<ClubActivity>()
        }

        sub_club.setOnClickListener{
            startActivity<ClubActivity>()
        }

        Notice.setOnClickListener{
            startActivity<Main_Notice>(
                "Title" to "공지사항"
            )
        }

        Information.setOnClickListener{ startActivity<Account>() }

        Sign_in.setOnClickListener{ startActivity<LoginActivity>() }

        Sign_Up.setOnClickListener{ startActivity<Signup>() }

    }
}
