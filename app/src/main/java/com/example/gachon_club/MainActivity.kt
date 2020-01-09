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

        Main_club.setOnClickListener{ startActivity<Main_Club>() }
        Login.setOnClickListener{ startActivity<LoginActivity>() }
    }
}
