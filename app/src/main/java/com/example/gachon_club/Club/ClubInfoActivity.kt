package com.example.gachon_club.Club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.gachon_club.Club.Adapter.ViewPagerAdapter
import com.example.gachon_club.R
import com.google.android.material.tabs.TabLayout

class ClubInfoActivity : AppCompatActivity() {

    private var fragmentPagerAdapter: FragmentPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_info)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        fragmentPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        viewPager.adapter = fragmentPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}