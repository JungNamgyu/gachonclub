package com.example.gachon_club

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.navigation.ui.AppBarConfiguration
import com.example.gachon_club.Account.Model.User
import com.example.gachon_club.Account.SignInActivity
import com.example.gachon_club.Account.SignUpActivity
import com.example.gachon_club.Club.ClubActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        Main_club.setOnClickListener{
            startActivity<ClubActivity>()
        }

        Sign_in.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivityForResult(intent, 100)
        }
        Sign_up.setOnClickListener{
            startActivity<SignUpActivity>()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed(){
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawers()
        }
        else{
            super.onBackPressed()
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                100 -> {
                    var user = data!!.getParcelableExtra<User>("userInfo")
                    userName.text = user?.name
                    userMajor.text = user?.major
                    userClub.text = user?.club
                    userPosition.text = user?.position
                }
            }
        }
    }
}
