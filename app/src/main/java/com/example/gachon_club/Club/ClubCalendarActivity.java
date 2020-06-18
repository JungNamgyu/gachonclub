package com.example.gachon_club.Club;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gachon_club.R;


public class ClubCalendarActivity extends Fragment {
    private View view;

    public static ClubCalendarActivity newInstance(){
        ClubCalendarActivity clubCalendarActivity = new ClubCalendarActivity();
        return clubCalendarActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_club_calendar, container, false);

        return view;
    }
}