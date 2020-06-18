package com.example.gachon_club.Club.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gachon_club.Club.ClubCalendarActivity;
import com.example.gachon_club.Club.ClubNoticeActivity;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // 프래그먼트를 보여주는 처리를 구현한 부분
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ClubNoticeActivity.newInstance();
            case 1:
                return ClubCalendarActivity.newInstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    // 상단의 탭 레이아웃 인디케이터 쪽에 텍스트 선언
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "공지사항";
            case 1:
                return "일정";
            default:
                return null;
        }
    }
}